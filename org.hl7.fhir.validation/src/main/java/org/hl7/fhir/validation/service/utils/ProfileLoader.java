package org.hl7.fhir.validation.service.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;

public class ProfileLoader {
  public static byte[] loadProfileSource(String src) throws FHIRException, IOException {
    if (Utilities.noString(src)) {
      throw new FHIRException("Profile Source '" + src + "' could not be processed");
    } else if (Common.isNetworkPath(src)) {
      return loadProfileFromUrl(src);
    } else if (ManagedFileAccess.file(src).exists()) {
      return loadProfileFromFile(src);
    } else {
      throw new FHIRException("Definitions Source '" + src + "' could not be processed");
    }
  }

  private static byte[] loadProfileFromUrl(String src) throws FHIRException {
    try {
      HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), src + "?nocache=" + System.currentTimeMillis());
      res.checkThrowException();
      return res.getContent();
    } catch (Exception e) {
      throw new FHIRException("Unable to find definitions at URL '" + src + "': " + e.getMessage(), e);
    }
  }

  private static byte[] loadProfileFromFile(String src) throws IOException {
    File f = ManagedFileAccess.file(src);
    if (f.isDirectory())
      throw new IOException("You must provide a file name, not a directory name");
    return FileUtilities.fileToBytes(src);
  }

}
