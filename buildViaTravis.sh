#!/usr/bin/env bash

# Start the overall build
./gradlew build

# Run tests and checks
./gradlew check

# Generate code coverage report
./gradlew codeCoverageReport
