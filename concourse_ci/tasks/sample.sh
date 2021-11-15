#!/bin/bash

echo "Docker version $(docker version)"
echo "Current directory: $PWD"
DIR_CONTENT=$(ls -lar)
echo "Current directory content: $DIR_CONTENT"