package src;

public class obj_Animal implements utils_ObjectGen {
    private String name, age, a_class, family, species, gender, mood, favFood;

    public obj_Animal(String[] animaldetails) {
        this.name = animaldetails[0];
        this.age = animaldetails[1];
        this.gender = animaldetails[2];
        this.a_class = animaldetails[3];
        this.family = animaldetails[4];
        this.species = animaldetails[5];
        this.favFood = animaldetails[6];
        if (animaldetails[7] == " ") {
            this.mood = " ";
        } else {
            this.mood = animaldetails[7];
        }

    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getA_class() {
        return a_class;
    }

    public String getFamily() {
        return family;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getFavFood() {
        return favFood;
    }

    public String getMood() {
        return mood;
    }

    public void setA_class(String a_class) {
        this.a_class = a_class;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + gender + "," + a_class + "," + family + "," + species + "," + favFood
                + ","
                + mood;
    }

    public void writetoDB() {
        utils_DBManager DB = new utils_DBManager();
        DB.populateDB(this);
    }

}
