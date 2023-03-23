#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
java -jar "$DIR/Digital-OE.jar" "$1"
