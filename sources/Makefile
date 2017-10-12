# Microprojet ACDA 3.1 par Romain Simon et Yann Pascoet

JFILES = Chambre.class \
  	  Client.class \
	  ChambreDeuxLitsSimples.class \
	  ChambreLitDouble.class \
	  ChambreLitSimple.class \
	  Reservation.class \
	  Projets_v1.java

JC = javac

but : $(JFILES)

Chambre.class : Chambre.java
	$(JC) Chambre.java

Client.class : Client.java
	$(JC) Client.java

Reservation.class : Reservation.java
	$(JC) Reservation.java

ChambreDeuxLitsSimples.class : ChambreDeuxLitsSimples.java Chambre.java
	$(JC) ChambreDeuxLitsSimples.java

ChambreLitDouble.class : ChambreLitDouble.java Chambre.java
	$(JC) ChambreLitDouble.java Chambre.java

ChambreLitSimple.class : ChambreLitSimple.java Chambre.java
	$(JC) ChambreLitSimple.java Chambre.java

Projets_V1.class : Projets_v1.java
	$(JC) Projets_v1.java

clean : 
	-rm *.class 

.PHONY : but clean
