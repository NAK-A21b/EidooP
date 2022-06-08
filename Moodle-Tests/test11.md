## ACHTUNG! Die Reihenfolge der Multiple-Choice Aufgabe ist zufällig! ##

# Frage 1 #

1. Laden sie das Projekt network-v3 oder arbeiten Sie mit Ihrem Projekt aus der letzten Lektion weiter.
2. Fügen Sie je eine display() Methode in MessagePost und in PhotoPost ein, die die subklassenspezifischen Informationen ausgibt (rufen Sie nicht die ererbte Methode auf!).
3. Überprüfen Sie, dass die show-Methode aus NewsFeed die Methoden aus MessagePost und aus PhotoPost aufruft, aber nicht die aus Post.

```java
//import Statements für alle Klassen und Interfaces
import java.util.ArrayList;

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

public interface IPost{
    public void display();
}

public class Post implements IPost{
    public Post(String author){
        this.username=author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

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

    public long getTimeStamp() {
        return timestamp;
    }

    public void display() {
        System.out.println(username);
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


public class MessagePost  extends Post {
    private String message;   // an arbitrarily long, multi-line message

    public MessagePost(String author, String text)    {
        super(author);
        message = text;
    }

    public String getText()    {
        return message;
    }
    
    @Override
    public void display(){
        System.out.println(message);
    }

}


public class PhotoPost extends Post{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption

    public PhotoPost(String author, String filename, String caption){
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    public String getImageFile(){
        return filename;
    }

    public String getCaption() {
        return caption;
    }
    
    @Override
    public void display(){
        System.out.println("  [" + filename + "]");
        System.out.println("  " + caption);
    }

}
```

# Frage 2 #

1. Als Erweiterung der letzten Übung fügen Sie je eine super.display(); Anweisung in die subklassenspezifischen display-Methoden ein.
2. Überprüfen Sie das Ergebnis.
3. Warum ist das Ergebnis nicht optimal?

```java
//import Statements für alle Klassen und Interfaces
import java.util.ArrayList;

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

public interface IPost{
    public void display();
}

public class Post implements IPost{
    public Post(String author){
        this.username=author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

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

    public long getTimeStamp() {
        return timestamp;
    }

    public void display() {
        System.out.println(username);
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


public class MessagePost  extends Post {
    private String message;   // an arbitrarily long, multi-line message

    public MessagePost(String author, String text)    {
        super(author);
        message = text;
    }

    public String getText()    {
        return message;
    }
    
    @Override
    public void display(){
        System.out.println(message);
        super.display();
    }
 
}


public class PhotoPost extends Post{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption

    public PhotoPost(String author, String filename, String caption){
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    public String getImageFile(){
        return filename;
    }

    public String getCaption() {
        return caption;
    }
    
    @Override
    public void display(){
        System.out.println("  [" + filename + "]");
        System.out.println("  " + caption);
        super.display();
    }
    
}
```

# Frage 3 #

1. Deklarieren Sie die Klasse Post als abstract.
2. Versuchen Sie ein Objekt der Klasse Post mit in der Direkteingabe mit new Post(" Lilienthal"); zu erzeugen. Wie lautet die Fehlermeldung, die Sie von BlueJ bekommen/Wie lautet der Fehlertext zur der Code-Stelle in Eclipse oder IntelliJ?

Fügen Sie die Antwort per cut&paste hier ein:

```Post is abstract; cannot be instantiated```

# Frage 4 #

1. Fügen Sie eine abstrakte Methode displaySpecial() in die Klasse Post ein.
2. Machen Sie display in Post zu einer Templatemethode, indem Sie an der richtigen Stelle displaySpecial() aufrufen.
3. In MessagePost und in PhotoPost soll die display Methode in displaySpecial() umbenannt werden

```java
//import Statements für alle Klassen und Interfaces
import java.util.ArrayList;

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

public interface IPost{
    public void display();
}

public abstract class Post implements IPost{
    public Post(String author){
        this.username=author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

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

    public long getTimeStamp() {
        return timestamp;
    }
    
    public void display() {
        System.out.println(username);
        displaySpecial();
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
    
    public abstract void displaySpecial();

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


public class MessagePost  extends Post {
    private String message;   // an arbitrarily long, multi-line message

    public MessagePost(String author, String text)    {
        super(author);
        message = text;
    }

    public String getText()    {
        return message;
    }

    public void displaySpecial(){
        System.out.println(message);
    }
 
 
}


public class PhotoPost extends Post{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption

    public PhotoPost(String author, String filename, String caption){
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    public void displaySpecial(){
        System.out.println("["+filename+"]");
        System.out.println(caption);
    }
    
    public String getImageFile(){
        return filename;
    }

    public String getCaption() {
        return caption;
    }

}
```

# Frage 5 #

Welche der Bestandteile gehören zu einer vollen Methodensignatur?
Wählen Sie eine oder mehrere Antworten:

- [x] Der Methodenname
- [ ] Der Code der Methode
- [ ] Die Namen der Parameter
- [ ] Die aktuellen Parameter
- [ ] Der Sichtbarkeitsmodifier
- [x] Der Rückgabetyp.
- [x] Die Typen der Parameter

# Frage 6 #

Die Tierwelt von Winnie Pooh wird durch die folgenden Klassen beschrieben:

public interface IAnimal {
	void feed();
}

public abstract class Animal implements IAnimal{
	private String name;
	public Animal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void feed() {
		System.out.println(name+": hrrr");
	}
}

public class Tiger extends Animal{
	public Tiger(String name) {
		super(name);
	}
	public void feed() {
		super.feed();
		System.out.println("Roaaaar");
	}
}

public class Donkey extends Animal {
	public Donkey(String name) {
		super(name);
	}
	public void feed() {
		System.out.println("Eeyore");
	}
} 

Bestimmen sie die Ausgabe von folgenden Anweisungen:

Donkey d = new Donkey("Eeyore");
d.feed();

Wählen Sie eine Antwort:

- [x] Ausgabe auf die Konsole:
Eeyore
- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr
Eeyore
- [ ] Ausgabe auf die Konsole:
Eeyore
Eeyore: hrrr
- [ ] Fehlermeldung
Die Anweisungsfolge ist nicht compilierbar.
- [ ] Nichts von allem.
- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr

# Frage 7 #

Beziehen sich auf das Beispiel: Die Tierwelt von Winnie Pooh.

Bestimmen sie die Ausgabe von folgenden Anweisungen:

IAnimal d = new Donkey("Eeyore");
d.feed();


Bitte beachten Sie: 

Gehen Sie davon aus, dass der Code in eine main-Methode eingebettet wurde. Ggf. notwendige Imports sind als gegeben anzusehen.

Wählen Sie eine Antwort:

- [ ] Ausgabe auf die Konsole:
Eeyore
Eeyore: hrrr
- [ ] Nichts von allem.
- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr
- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr
Eeyore
- [x] Ausgabe auf die Konsole:
Eeyore
- [ ] Fehlermeldung
Die Anweisungsfolge ist nicht compilierbar.

# Frage 8 #

Beziehen sich auf das Beispiel: Die Tierwelt von Winnie Pooh.

Bestimmen sie die Ausgabe von folgenden Anweisungen:

IAnimal d = new Animal("Eeyore");
d.feed();


Bitte beachten Sie: 

Gehen Sie davon aus, dass der Code in eine main-Methode eingebettet wurde. Ggf. notwendige Imports sind als gegeben anzusehen.


Wählen Sie eine Antwort:

- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr
Eeyore
- [ ] Ausgabe auf die Konsole:
Eeyore
Eeyore: hrrr
- [ ] Ausgabe auf die Konsole:
Eeyore
- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr
- [ ] Nichts von allem.
- [x] Fehlermeldung
Die Anweisungsfolge ist nicht compilierbar.

# Frage 9 #

Beziehen sich auf das Beispiel: Die Tierwelt von Winnie Pooh.

Bestimmen sie die Ausgabe von folgenden Anweisungen:

ArrayList<IAnimal> animals = new ArrayList<>();
animals.add(new Tiger("Tigger"));
animals.add(new Donkey("Eeyore"));
for (IAnimal a : animals){
  a.feed();
}


Bitte beachten Sie: 

Gehen Sie davon aus, dass der Code in eine main-Methode eingebettet wurde. Ggf. notwendige Imports sind als gegeben anzusehen.


Wählen Sie eine Antwort:

- [ ] Fehlermeldung
Die Anweisungsfolge ist nicht compilierbar.
- [x] Ausgabe auf die Konsole:
Tigger: hrrr
Roaaaar
Eeyore
- [ ] Ausgabe auf die Konsole:
Eeyore
Tigger: hrrr
- [ ] Nichts von allem.
- [ ] Ausgabe auf die Konsole:
Eeyore: hrrr
Tigger: hrrr
- [ ] Ausgabe auf die Konsole:
Eeyore
Roaaaar
  
# Frage 10 #

- Ohne Verwendung abstrakter Klassen und Interfaces kann bessere Wiederverwendbarkeit und ```Wartbarkeit``` nicht erreicht werden.
- Klassen wie NewsFeed verwenden immer ein/e ```Interface``` und niemals eine ```Implementierung```.
- Das Interface bietet genau die Methoden an, die die ```Nutzer``` brauchen. Nicht mehr und nicht weniger.
- Sorgfältig gewählte Interfaces ändern sich ```selten```.
- Konkrete Klassen ändern sich ```häufig```.
  
# Frage 11 #
  
Welche der Aussagen ist plausibel?
Wählen Sie eine Antwort:

- [ ] Interfaces sollten default Implementierungen für Methoden anbieten, da dadurch Codeduplikationen reduziert werden.
- [x] Interfaces sollten default Implementierungen für Methoden anbieten, die neu in ein Interface aufgenommen werden.
- [ ] Interfaces sollten default Implementierungen anbieten, weil dadurch die konkreten Klassen von unnötigem Codeballast befreit werden.
  
# Frage 12 #
  
Sie sollen die Anwendung Entenrennen weiterentwickeln, um die Codeduplizierungen in den Entenklassen zu reduzieren.

1. Führen Sie eine abstrakte Klasse Duck ein, die IDuck implementiert. 
2. Bringen sie die gemeinsamen Attribute in die Klasse Duck. Verwenden sie als Sichtbarkeitsmodifier private!
3. Bringen Sie die gemeinsamen Methoden in die Klasse Duck. Machen Sie die Methode run() zur Templatemethode, um die gelaufene Distanz zu aktualisieren.

Wichtig: Ihre Abgabe soll alle Klassen und Interfaces in das Eingabefenster kopieren. Erforderliche imports für alle Klassen und Interfaces müssen ganz zu Beginn angegeben werden.  Orientieren Sie sich an der Vorlage.

```java
import java.util.ArrayList;
import java.util.Random;

public interface IDuck {

	String showData();
	void run();
	int getDistance();

    
}

public abstract class Duck implements IDuck{
    private final String name;
    private int distance = 0;
    
    public Duck(String name){
        this.name = name;
    }
    
    public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String showData() {
		return name+" Distance "+ distance;
	}
	
	public void run(){
	    distance += runSpecial();
	}
	protected abstract double runSpecial();
	
}

public class SittingDuck extends Duck{
	public SittingDuck(String name) {
		super(name);
	}
    
    @Override
	public double runSpecial(){
	    return 0;
	}
}

public class TiringDuck extends Duck{
    private static final int SPEED = 10;
	private int fatigue=0;
	private final Random random = new Random();
	
	public TiringDuck(String name) {
		super(name);
	}
	
	public int getFatigue() {
		return fatigue;
	}
	
	@Override
	public double runSpecial() {
		fatigue+= 2*random.nextDouble()*SPEED;
		return SPEED  - SPEED *  ( 1 - 100.0/(100+fatigue));
	}
}

public class RandomDuck extends Duck{
    private static final int SPEED = 10;
	private final Random random = new Random();
	
	public RandomDuck(String name) {
		super(name);
	}
	
	@Override
	public double runSpecial() {
		return SPEED * random.nextDouble();
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

























