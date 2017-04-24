#!/bin/bash
make
sudo cp libcec-interface.so /usr/local/lib/libcec-interface.so
sudo ldconfig /usr/local/lib
