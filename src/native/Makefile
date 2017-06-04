LIBRARY := libcec-interface.so
OBJFILES := CECInterface.o
INCLUDES := -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include/linux -I/usr/local/include/libcec -I/usr/include

CXXFLAGS := -fPIC $(INCLUDES) -std=c++11

$(LIBRARY): $(OBJFILES)
	$(CXX) -shared -o $@ $^ -lcec

clean :
	rm $(OBJFILES) $(LIBRARY)
