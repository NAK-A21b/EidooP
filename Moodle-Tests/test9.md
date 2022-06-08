## ACHTUNG! Die Reihenfolge der Aufgaben ist zufällig! ##

# Frage 1 #

Gegeben das interface


public interface IDo{
    int doIt();
}


Erstellen Sie eine Klasse Do, so dass die Zuweisung

IDo d = new Do();

kompilierbar wird.

```java
public class Do implements IDo{
    public int doIt(){
        return 73;
    }
}
```

# Frage 2 #

Welche der folgenden Aussagen sind wahr?

- [ ] Polymorphie ist zu vermeiden, weil nicht mehr klar ist, welchen Typ ein Objekt hat.
- [x] Polymorphe Variablen können Objekte eines anderen Typs aufnehmen als des deklarierten Typs.
- [x] Subtyping ermöglicht Polymorphie weil die Untertypen anstelle der Obertypen auch verwendet werden dürfen.
- [x] Polymorphie ermöglicht die Erweiterbarkeit von Programmsystemen, da Programme auf Klassen angewendet werden können, die erst später hinzugefügt werden.
- [ ] Polymorphie dient zur Vermeidung der Codeduplizierung innerhalb einer Vererbungshierarchie.

# Frage 3 #

Setzen sie die Schnittstellenvererbung wie in der Vorlesung besprochen in dem Netzwerk Beispielprojekt ein. Sie können ein BlueJ Startprojekt herunterladen.

Wichtig: Ihre Abgabe soll alle Klassen und Interfaces in das Eingabefenster kopieren. Erforderliche imports für alle Klassen und Interfaces müssen ganz zu Beginn angegeben werden.  Orientieren Sie sich an der Vorlage.

```java
//import Statements für alle Klassen und Interfaces
import java.util.ArrayList;
//-----------------------------------------------------------------------------------------
public class NewsFeed{
    private ArrayList<IPost> posts;
    public NewsFeed() {
        posts = new ArrayList<>();
    }
    public void addPost(IPost post) {
        posts.add(post);
    }
    public void show() {
        for(IPost post : posts) {
            post.display();
            System.out.println();   // empty line between posts
        }
    }
}
//--------------------------------------------------------------------------------------
public class MessagePost implements IPost{
    private String username;  // username of the post's author
    private String message;   // an arbitrarily long, multi-line message
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;
    public MessagePost(String author, String text)    {
        username = author;
        message = text;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }
    public void like()   {
        likes++;
    }
    public void unlike(){
        if (likes > 0) {
            likes--;
        }
    }
    public void addComment(String text)    {
        comments.add(text);
    }
    public String getText()    {
        return message;
    }
    public long getTimeStamp() {
        return timestamp;
    }
    public void display() {
        System.out.println(username);
        System.out.println(message);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    private String timeString(long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
//----------------------------------------------------------------
public class PhotoPost implements IPost{
    private String username;  // username of the post's author
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;
    public PhotoPost(String author, String filename, String caption){
        username = author;
        this.filename = filename;
        this.caption = caption;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }
    public void like() {
        likes++;
    }
    public void unlike()    {
        if (likes > 0) {
            likes--;
        }
    }
    public void addComment(String text)  {
        comments.add(text);
    }
    public String getImageFile(){
        return filename;
    }
    public String getCaption() {
        return caption;
    }
    public long getTimeStamp() {
        return timestamp;
    }
    public void display()   {
        System.out.println(username);
        System.out.println("  [" + filename + "]");
        System.out.println("  " + caption);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        } else {
            System.out.println();
        }
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        } else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    
    private String timeString(long time){
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
public interface IPost{
    void display();
}
```

# Frage 4 #

Gegeben sei folgendes Interface:

public interface IDoSomething{
  void doSomething();
}


public class DoSomething implements IDoSomething{
  public void doSomething(){
    System.out.println("Working hard");
  }
}


public class DoSomethingElse implements IDoSomething{
  public void doSomething(){
    System.out.println("Working even harder");
  }
}

Welche der Zuweisungen sind korrekt?
Wählen Sie eine oder mehrere Antworten:

- [ ] DoSomething doit = new DoSomethingElse();
- [ ] IDoSomething doit = new DoSomethingElse();
      DoSomething doit2 = doit;
- [x] IDoSomething doit = new DoSomething();
- [x] IDoSomething doit = new DoSomethingElse();
- [x] DoSomething doit = new DoSomething();
      IDoSomething doit2 = doit;
- [ ] IDoSomething doit = new DoSomething();
      DoSomething doit2 = doit;
- [ ] IDoSomething doit = new IDoSomething();


# Frage 5 #

Die Nordakademie beherbergt auf Ihrem Teich unterschiedliche Arten von Enten. Dies inspiriert Sie ein Java Programm Entenrennen zu schreiben.
Gegeben sind folgende drei Klassen: RandomDuck, TiringDuck und DuckRace.
DuckRace ist eine Klasse mit der ein Entenrennen durchgeführt werden kann. Über addTDuck(TiringDuck) und addRDuck(RandomDuck) können Teilnehmer des Entenrennens hinzugefügt werden. race() startet ein Entenrennen der beteiligten Enten und gibt die Gewinner über 100 m aus.
TiringDuck und Random Duck Objekte laufen mit variierenden Geschwindigkeiten, die in der Methode run ermittelt wird. TiringDuck wird im Laufe des Rennens immer müder und damit langsamer und RandomDuck läuft mal schnell mal langsam. Jeder Aufruf von run bringt die Enten ein Stück voran. Um ans Ziel Rennens zu kommen muss die Methode mehrfach ausfgeführt werden, getDistance gibt die die total zurückgelegte Strecke in m an.  
Das Problem ist die Codeduplizierung in der Klasse Duckrace, da sowohl RandomDucks als auch TiringDucks verwaltet werden sollen. Es geht in der Übung darum, diese Codeduplizierung zu entfernen.
1. Führen Sie ein Interface IDuck ein. Es enthält nur die Methoden, die in DuckRace benutzt werden. Schauen Sie in den Code welche Methoden dies sind!
2. Schreiben Sie die Klasse DuckRace so um, dass Sie nur IDuck nutzt. Sie müssen dafür die Nutzung der Klassen TiringDuck und RandomDuck durch IDuck ersetzen und die Duplizierungen sinnerhaltend entfernen.
3. Die Klassen TiringDuck und RandomDuck sollen für IDucks eingesetzt werden können.
4. Fügen Sie eine neue Klasse SittingDuck ein, die sich nicht bewegt. Testen Sie DuckRace mit einer SittingDuck und einer TiringDuck.
Wichtig: Ihre Abgabe soll alle Klassen und Interfaces in das Eingabefenster kopieren. Erforderliche imports für alle Klassen und Interfaces müssen ganz zu Beginn angegeben werden.  Orientieren Sie sich an der Vorlage.
Sie können die Startklassen als BlueJ Projekt herunterladen. 

```java
import java.util.ArrayList;
import java.util.Random;
public interface IDuck {
	String showData();
	void run();
	int getDistance();
    
}
public class SittingDuck implements IDuck{
	private final String name;
	public SittingDuck(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getDistance() {
		return 0;
	}
	public void run() {
	}
	public String showData() {
		return name+" Distance "+0;
	}
}
public class TiringDuck implements IDuck{
	private static final int SPEED = 10;
	private final String name;
	private int distance=0;
	private int fatigue=0;
	private final Random random = new Random();
	public TiringDuck(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getDistance() {
		return distance;
	}
	public int getFatigue() {
		return fatigue;
	}
	public void run() {
		fatigue+= 2*random.nextDouble()*SPEED;
		distance += SPEED - SPEED* ( 1 - 100.0/(100+fatigue));
	}
	public String showData() {
		return name+" Distance "+distance;
	}
}
public class RandomDuck implements IDuck{
	private static final int SPEED = 10;
	private final String name;
	private int distance=0;
	private final Random random = new Random();
	public RandomDuck(String name) {
		super();
		this.name = name;
	}
	public void run() {
		distance += SPEED * random.nextDouble();
	}
	public String getName() {
		return name;
	}
	public int getDistance() {
		return distance;
	}
	public String showData() {
		return name+" Distance "+distance;
	}
	
}
public class DuckRace {
	private final int RACE_DISTANCE = 100;
	private ArrayList<IDuck> ducks = new ArrayList<>();
	public void race() {
		while (!hasWinner()) {
			ducksRun();
		}
	}
	private boolean hasWinner() {
		ArrayList<IDuck> bestDucks = new ArrayList<>();
		int max = 0;
		for (IDuck duck : ducks) {
			if (duck.getDistance() > RACE_DISTANCE) {
				if (duck.getDistance() > max) {
					max = duck.getDistance();
					bestDucks = new ArrayList<>();
					bestDucks.add(duck);
				} else if (duck.getDistance() == max) {
					bestDucks.add(duck);
				}
			}
		}
		if (!bestDucks.isEmpty()) {
			for (IDuck r: bestDucks) {
				System.out.println(r.showData());
			}
		}
		return !bestDucks.isEmpty();
	}
	private void ducksRun() {
		for (IDuck duck : ducks) {
			duck.run();
		}
	}
	
	public void addDuck (IDuck duck) {
		ducks.add(duck);
	}
}
```

# Frage 6 #

Welchen Nutzen kann man durch Interfaces realisieren?

- [ ] Interfaces helfen Codeduplikationen innerhalb einer Implementierungshierarchie zu vermeiden, weil sie eine gemeinsame Codebasis erzwingen.
- [x] Interfaces helfen dabei, andere Klassen wiederverwendbar zu machen.
- [x] Interfaces vermeiden Codeduplikationen in anderen Klassen, weil diese nicht verschiedene Implementationen berücksichtigen müssen.
- [x] Wenn eine Klasse ein Interface nutzt statt auf die Implementationen zuzugreifen, braucht sie bei dem Hinzufügen einer neuen Implementationsklasse nicht mehr geändert zu werden.
- [x] Interfaces stellen Erweiterungspunkte dar, die unterschiedliche Implementationen zulassen. Neue Implementationen machen dann keine Modifikationen mehr nötig. 

# Frage 7 #

Welche der folgenden Aussagen sind richtig? Sie können mehrere auswählen.

- [ ] Interfaces können eine Klasse implementieren. 
- [ ] Interfaces können Exemplarvariablen haben, wenn diese public und final sind. 
- [x] Interfaces können Methoden deklarieren, ohne dafür Methodenrümpfe anzugeben.
- [x] Alle in Interfaces deklarierten Methoden sind public, egal ob ein Sichtbarkeitsmodifikator angegeben ist oder nicht.
- [ ] Interfaces haben immer genau einen Konstruktor, nämlich einen Zero-Argument Konstruktor. 
- [x] Interfaces können keine Exemplarvariablen definieren, was auch immer für Modifier (public, private, final, ... ) angegeben werden.
