#Microprojet ACDA 3.1 par Romain Simon et Yann Pascoet

JFILES = Statistiques.class\
	  Calculateur.class\

JC = javac

but : $(JFILES)

Calculateur.class : Calculateur.java
	$(JC) Calculateur.java

Statistiques.class : Statistiques.java
	$(JC) Statistiques.java

test :
	-java -cp "../packages/mariadb-client.jar:." Statistiques

clean :
	-rm *.class

.PHONY : but clean
