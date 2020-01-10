#!/bin/sh
docker build . -t circulo7/cal-util:0.0.2
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 circulo7/cal-util"
