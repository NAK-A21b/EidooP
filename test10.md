## ACHTUNG! Die Reihenfolge der Multiple-Choice Aufgabe ist zufällig! ##

# Frage 1 #

Setzen sie die Vererbung in dem Projekt network-v2 ein.

1. Erstellen Sie eine Oberklasse Post, die das IPost-Interface implementiert.
2. Fügen Sie die gemeinsamen Exemplarvariablen mit der Sichtbarkeit protected hinzu und löschen Sie diese aus MessagePost und PhotoPost.
3. Fügen sie Konstruktoren in Post, MessagePost und PhotoPost hinzu.
4. Um die Klasse Post compilierbar zu machen, fügen Sie temporär eine Methode public void display(){} ein.

Wichtig: Ihre Abgabe soll alle Klassen und Interfaces in das Eingabefenster kopieren. Erforderliche imports für alle Klassen und Interfaces müssen ganz zu Beginn angegeben werden.  Orientieren Sie sich an der Vorlage.

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
    protected String username;
    protected long timestamp;
    protected int likes;
    protected ArrayList<String> comments;
    
    public Post(String author){
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }
    public void display(){
        
    }
}

public class MessagePost extends Post{
    private String message;   // an arbitrarily long, multi-line message
    

    public MessagePost(String author, String text){
        super(author);
        message = text;
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



public class PhotoPost extends Post{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption
    

    public PhotoPost(String author, String filename, String caption){
        super(author);
        this.filename = filename;
        this.caption = caption;
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
```

# Frage 2 #

Kann eine Klasse mehrere Klassen erweitern? (Beispiel public class A extends B,C{...})
Wählen Sie eine Antwort:

- [ ] Nein, es sei denn eine der Klassen deklariert keine Methoden und keine Exemplarvariablen.
- [ ] Ja, aber erst ab Java Version 9, wenn Klasse B und C auch public sind.
- [x] Nein, Java unterstützt das nicht.
- [ ] Ja, wenn die erweiterten Klassen B und C dasselbe Interface implementieren.

# Frage 3 #

Kann eine Klasse von sich selbst erben?
Wählen Sie eine Antwort:

- [x] Nein
- [ ] Unter gewissen Voraussetzungen.
- [ ] Ja
- [ ] Nichts von alledem ist richtig.

# Frage 4 #

Wählen sie die richtigen Aussagen aus.
Wählen Sie eine oder mehrere Antworten:

- [ ] Auch private Variablen der Oberklasse werden an die Unterklassen vererbt und können in der Unterklasse benutzt werden.
- [x] Objekte der Unterklassen speichern auch alle Exemplarvariablen der Oberklasse unabhängig von Ihrer Sichtbarkeit. Sie sind aber möglicherweise nicht in der Unterklasse zugreifbar.
- [ ] Exemplarvariablen, die nicht public sind, werden nicht an die Unterklasse vererbt.
- [ ] Um eine Exemplarvariable der Oberklasse in der Unterklasse erben zu können, muss in der Unterklasse diese Variable mit identischem Namen und identischer Sichtbarkeit deklariert werden.

# Frage 5 #

In der Programmiersprache Java, kann ein Konstruktor einer Oberklasse an seine Subklassen vererbt werden?
Wählen Sie eine oder mehrere Antworten:

- [ ] Konstruktoren werden immer vererbt.
- [ ] public Kostruktoren werden vererbt.
- [x] Konstruktoren werden nie vererbt.
- [ ] protected Konstruktoren werden vererbt.

# Frage 6 #

Die erste Sache, die ein Konstruktor einer Klasse macht ist:
Wählen Sie eine Antwort:

- [ ] Der Aufruf des Garbage Collectors, der Speicherplatz für das Objekt zur Verfügung stellt.
- [ ] Aufruf der init() Methode.
- [ ] Die start() Methode
- [ ] Aufruf eines Konstruktors der Oberklasse, selbst wenn dieser Aufruf nicht explizit programmiert ist

# Frage 7 #

Nehmen Sie an, Sie haben folgende Klassen:

1   public class Post{
2     private String username;
3   
4     public Post(String author){
5       username = author;
6     }
7   }
1   public class MessagePost extends Post{
2     private String text;
3     public MessagePost(String author, String text){
4       username=author;
5       this.text=text;
6    }
7   }

Der Compiler zeigt Fehler beim compilieren von MessagePost. Welche Massnahme erzeugt eine compilierbare Klasse MessagePost?
Wählen Sie eine oder mehrere Antworten:

- [x] Verwenden von protected in Zeile 2 von Post und Einfügen eines Konstruktors public Post(){ username="unknown"} und Einfügen des Aufrufs super(); zwischen 3 und 4 von MessagePost.
- [ ] Verwenden von protected in Zeile 2 von Post und ändern der Zeile 4 von MessagePost in this.username=author;
- [ ] Verwenden von protected in Zeile 2 von Post und Einfügen von super(author);  nach Zeile 5 von MessagePost.
- [ ] Verwenden von protected in Zeile 2 von Post.
- [x] Ändern der Zeile 4 von MessagePost in super(author);
- [x] Verwenden von protected in Zeile 2 von Post und einfügen eines Konstruktors public Post(){ username="unknown"}

# Frage 8 #

Nun, da die Attribute umgezogen sind, wird es Zeit, auch die entsprechenden Methoden auf Basis Ihrer Version von network-v2 zu verschieben.

1. Kopieren Sie die Methoden, die nur Variablen aus Post nutzen aus MessagePost und PhotoPost in die Klasse Post, und löschen Sie die Methoden aus den Unterklassen.
2. Achtung: Bei der display Methode haben Sie das Problem, dass diese Methode in den beiden Unterklassen anders ist, weil auf die Exemplarvariablen der Unterklassen zugegriffen wird. Entfernen Sie diese Zugriffe deshalb und ziehen Sie die modifizierte display Methode in die Klasse Post hoch, wie die anderen Methoden.
3. Setzen sie alle Variablen der Klasse Post auf private.

Wichtig: Ihre Abgabe soll alle Klassen und Interfaces in das Eingabefenster kopieren. Erforderliche imports für alle Klassen und Interfaces müssen ganz zu Beginn angegeben werden.  Orientieren Sie sich an der Vorlage.

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
    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    public Post(String author){
        this.username=author;
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
    
    public long getTimeStamp() {
        return timestamp;
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
    
    public void display() {
        System.out.println(username);
//        System.out.println(message);
//        System.out.println("  [" + filename + "]");
//        System.out.println("  " + caption);
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
}
```
# Frage 9 #

Post p = new Post("Autor");
MessagePost m = new MessagePost("author","text");
PhotoPost ph = new PhotoPost("author","filename","caption");

Welche der folgenden Anweisungsfolgen hat welchen Effekt?
### Zuweisungskompatibilität ###

| Befehl                   | Bwertung          |
|--------------------------|-------------------|
| p = m;                   | kein Problem      |
| p = ph;                  | kein Problem      |
|p = m; m = p;             | Compilezeitfehler |
| ph = m;                  | Compilezeitfehler |
|p = ph; ph = (PhotoPost)p;| kein Problem      |
|p = m; ph = (PhotoPost)p; | Laufzeitfehler    |
| p = (PhotoPost)m;        | Compilezeitfehler |


# Frage 10 #

Lesen sie den Artikel why-extends-is-evil.html und wählen Sie die Aussagen aus, die in dem Artikel vertreten werden.
Wählen Sie eine oder mehrere Antworten:

- [ ] Gelegentlich sind protected Variablen nützlich.
- [x] Das MFC Framework basiert auf Klassen, die erweitert werden müssen. Das führt zu Problemen, wenn sich die Version des Frameworks ändert.
- [ ] Das fragile "base class problem" beschreibt eine starke Abhängigkeit der Subklasse von ihrer Oberklasse.
- [x] Nach James Gosling, dem Erfinder von Java, sind Klassen ein Konzept, das er lieber nicht in Java aufgenommen hätte.
- [x] Die Verwendung von Klassen statt Interfaces erhöht den Änderungsaufwand.
- [x] Um Implementationsvererbung zu vermeiden, kann man bewährte Muster (Design Patterns) der Gang of Four verwenden.
- [x] Implementationsvererbung sollte durch Schnittstellenvererbung ersetzt werden.





















