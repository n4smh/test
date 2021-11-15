#!/bin/bash

echo "----------------------------------------------"
echo "Current directory: $PWD"

DIR_CONTENT=$(ls -la)
echo "Current directory content: $DIR_CONTENT"

GitVersion=$(git --version)
echo "Git version $GitVersion"

JavaVersion =$(java -version)
echo "Java version $JavaVersion"
echo "---------------------------------------------"
