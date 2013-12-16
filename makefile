#globals
default: build
freshen: clean build
clean: clean-specials
	rm -rf bin/*
clean-specials:
freshen: clean build

#variables
cp = -cp src:bin:lib/*
dest = -d bin
version = 
warnings = -Xlint:deprecation

#includes
include lists.mk
include dependencies.mk

#compilation definitions
$(class_files): bin/%.class : src/%.java
	javac $(cp) $(dest) $(version) $(warnings) $<

#commands
build: $(class_files)

test: run
run: build
	java $(cp) kiwistrongis.ss.Driver test

#other commands
git-prepare:
	git add -A
	git add -u
