#!/bin/bash

echo "----------------------------------------------"
echo "Current directory: $PWD"

DIR_CONTENT=$(ls -la)
echo "Current directory content: $DIR_CONTENT"

GitVersion=$(git --version)
echo "Git version $GitVersion"

echo "Java version $(java -version)"
echo "Maven version $(mvn -version)"
echo "---------------------------------------------"
