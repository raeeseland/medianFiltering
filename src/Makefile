# Better Makefile

JAVAC = javac
JFLAGS = -g

SOURCES = ParallelFiltering.java SequentialFiltering.java Main.java Test.java Driver.java

# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

#default rule - will be invoked by make
#class C has main method

Driver.class: ParallelFiltering.class SequentialFiltering.class Main.java Test.class Driver.java

#string substitute .java for .class in SOURCES
#to get dependency class files for def rule
#will force time check on all .class/.java files
 
# explicit rules
clean:
	@rm -f  $(SOURCES:.java=.class)
