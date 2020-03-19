# Java
## Reflection  
charger une classe, l'instancier, accéder à ses membres sans la connaitre par avance : 
```
Class byName =  Class.forName("com.mypackage.model.User"); 
Class byMethod = new User.getClass();
```

## Static 
indique de l'attribut/method appartient à la classe elle même au lien d'une instance spécifique
```
private static carNumber = 0;

public Car(){ 
  carNumber++; //chaque nouvelle voiture on augmente le nombre de voiture
}
```
## Serialization  
Sérializer un objet consiste à le convertir en un tableau d'octets, que l'on peut ensuite écrire dans un fichier, envoyer sur un réseau au travers d'une socket..

## Transient : empêche la serialisation d'un attribut
```
private transient String password; 
```



