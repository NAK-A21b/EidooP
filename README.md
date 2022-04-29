# Einführung in die Objektorientierte Programmierung

## Q2-2022

___

## Disclamer:

Dieses Projekt ist im Rahmen des Moduls "I166 - Einführung in die objektorientierte Programmierung" des Studiengangs
"Angewandte Informatik" an der Nordakademie Elmshorn erstellt worden.

Es dient lediglich dem Ziel, ein Beispiel zu zeigen, wie objektorientierte Programmierung in einem Projekt funktioniert.
Des Weiteren erhebt es keien Anspruch auf die Richtigkeit der Inhalte oder Funktionalität.

---

### Woche 1:

Es soll das Interface [IEventQueue](./src/IEventQueue.java) implementiert werden.
Realisieren Sie eine einfache Datenstruktur (auf Basis des gegebenen Interfaces). Nutzen Sie für E Object.

Die interne Verwaltung der Paare aus T und E soll dabei mittels der Entry Klasse realisiert werden. Sie benötigen somit
als Exemplarvariable eine Liste bzw. Queue.

Erstellen Sie ein einfaches Experiment. Füllen Sie ihre Datenstruktur mit n Einträgen und führen anschließend m dequeue
/ enqueue Paare auf dieser aus. Ermitteln Sie den Mittelwert pro dequeue / enqeue Paar (Zeit) und geben Sie diese aus.
Vergleichen Sie ihre Ergebnisse untereinander.
___

### Woche 2:

Ziel des heutigen Tages ist es den Test der letzten Woche nach OOP Ansätzen zu überarbeiten.

Wir trennen dazu

die Initialisierungsphase und
den Hold-Test (dequeue/enqueue-Paare) voneinander.
Dazu erstellen wir eine Klasse Experiment und definieren in dieser eine Methode zur Initialisierung der queue (
initialize) und eine Methode zur Durchführung des Tests (evaluate). Beide Methoden erhalten einen jeweils einen
ganzzahligen Parameter (initialSize und repetitions) Das Ergebnis des Tests soll zunächst eine Fließkommazahl sein, die
die durchschnittliche Dauer für die Ausführung eines dequeue / enqueue Paars beinhaltet.

Wir erstellen zudem eine main Methode, die die beiden Methoden n-fach aufruft und das durchschnittliche Ergebnis,
ausgibt. Das Ergebnis soll die Zeit der Initialisierung und die für das enq/dq Paar benötigte Zeit getrennt ausgeben.

Wir benötigen dazu die Implementierung der Ereignisschlage aus Aufgabe 1.

Sie müssen recherchieren: Wie die aktuelle Systemzeit ermittelt werden kann, wie Zufallszahlen erzeugt werden können (
Zeitstempel der Ereignisse)

#### Beobachten Sie:

Unterscheidet sich die Zeit des ersten Durchlaufs vom 2. vom 100.?
Hat die Größe der Queue (initialSize) einen Einfluss auf die durchschnittliche Zeit pro enq/deq Operation?
Nimmt die initialize-Zeit linea zur initialSize zu?

#### Überlegen Sie:

Die Implementierung der Queue lässt sich ggf. optimieren. Wann ist dies i.A. sinnvoll? Wie könnte man den Erfolg einer
Optimierung testen? Genügen unsere bisherigen Tests?
___

### Woche 3:

...
