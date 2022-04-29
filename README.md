## ACHTUNG! Die Reihenfolge der Multiple-Choice Aufgabe ist zufällig! ##

# Frage 1 #

### Welche der folgenden Bezeichner bezeichnen primitive Datentypen in Java? ###

- [x] <b>char</b>

- [ ] Float

- [x] <b>boolean</b>

- [ ] bool

- [x] <b>int</b>

- [ ] Integer

- [ ] Double

- [x] <b>short</b>

- [x] <b>long</b>

- [x] <b>byte</b>

- [ ] bit

- [ ] String

- [ ] Bit

- [x] <b>double</b>

- [x] <b>float</b>

- [ ] void

# Frage 2 #

### Welches ist/sind korrekte Wege in einem Programm ein neues Objekt der Klasse Person zu erzeugen? ###

- [ ] Person karl = Person("Kurt","Jürgens");

- [ ] Person anya = Person.new;

- [x] <b>Person naomi = new Person("Caroline","Munro");</b>

- [ ] Person james = Person.new("Roger", "Moore");

- [ ] Person q = new Person();

# Frage 3 #

### Ergänzen Sie die folgenden Lücken mit passenden Inhalten. Bei den ersten vier Fragen brauchen Sie nur auswählen, danach müssen Sie selbst etwas eingeben. ###

- public
- private
- private
- private
- String
- void
- String
- void
- int
- String
- void

Komplett:
~~~
public class Student {

    private String name;
    private String id;
    private int credits;

    public Student(String fullName, String studentID)   {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    public String getName() {
        return name;
    }

    public void changeName(String replacementName)  {
        name = replacementName;
    }

    public String getStudentID()    {
        return id;
    }

    public void addCredits(int additionalPoints)    {
        credits += additionalPoints;
    }

    public int getCredits()    {
        return credits;
    }

    public String getLoginName()    {
        return name.substring(0,4) + id.substring(0,3);
    }
   
    public void print()    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);
    }
}
~~~

# Frage 4 #

~~~
public class Module {
    private String code;
    private String name;
    private int contactHours;
    public Module(String _code, String _name){
        code=_code;
        name=_name;
    }
    public void setName(String _name){
        name=_name;
    }
    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public int getContactHours() {
        return contactHours;
    }
    public void setContactHours(int contactHours) {
        this.contactHours = contactHours;
    }

}
~~~

# Frage 5 #

### Welches ist/sind korrekte Aufrufe von Methoden? Es ist vorausgesetzt, dass die Variable person ein Personenobjekt enthält. ###

- [x] <b>new Person("Richard","Zimmerman").setFirstName("Bob");</b>

- [ ] person.lastName=setLastName("Nobel")

- [x] <b>person.setFirstName("Richard");</b>

- [ ] person.setLastName="Dylon"

- [ ] person=setLastName("Kiel");

# Frage 6 #

~~~
firstName=fName;
~~~

# Frage 7 #

~~~
public int relativeXPositionTo(Point p) {
    if (p.x == x) {
        return 0;
    } else if (p.x > x) {
        return -1;
    }
    return 1;
}
~~~

### Alternative ###

~~~
public int relativeXPositionTo(Point p) {
    if (p.getX() == x) {
        return 0;
    } else if (p.getX() > x) {
        return -1;
    }
    return 1;
}

public int getX() {
    return x;
}
~~~

# Frage 8 #

~~~
public class Tamagotchi {

    private final int hungerThreshold;
    private final int moodThreshold;
    private final int fatigueThreshold;
    private int hunger;
    private int mood;
    private int fatigue;

    public Tamagotchi(int hungerThreshold, int moodThreshold, int fatigueThreshold) {
        hunger = 0;
        mood = 0;
        fatigue = 0;
        this.hungerThreshold = hungerThreshold;
        this.moodThreshold = moodThreshold;
        this.fatigueThreshold = fatigueThreshold;
    }

    public void play() {
        if (hunger <= hungerThreshold) {
            hunger += 2;
            mood += 2;
            fatigue += 3;
        }
    }

    public void eat() {
        if (fatigue <= fatigueThreshold) {
            hunger -= 3;
            fatigue += 2;
        }
    }

    public void sleep() {
        if (hunger > hungerThreshold) {
            hunger++;
            mood--;
            fatigue = 0;
        } else {
            hunger++;
            mood++;
            fatigue = 0;
        }
    }

    public void pet() {
        hunger++;
        mood += 2;
    }

    public String getGeneralCondition() {
        if (fatigue > fatigueThreshold) {
            return "tired";
        }
        if (hunger > hungerThreshold) {
            return "hungry";
        }
        if (mood > moodThreshold) {
            return "happy";
        }
        return "indifferent";
    }

    public void makeHappy() {
        eat();
        sleep();
        pet();
    }
}
~~~