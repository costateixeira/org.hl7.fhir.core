## Validator Changes

* Control validation of FHIRPath functions
* Fix bug choosing incorrect servers for implied value sets
* Add ability to suppress validation by message parameters
* Issues are only raised against preferred bindings when they are defined in profiles (or in IG publisher)

## Other code changes

* Regular expression evaluation is now time constrained for FHIRPath, terminology services, and contained resources
* Fix missing assets and malformed icon URLs in comparison output
* Fix mapping representation for http URLs
* Fix json comparison bug
* Better error handling regenerating packages

