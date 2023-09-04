package ru.geekbrains.leson1;

public class Program{
     public static void main(String[] args) {
int[] ids = {1, 2, 3, 4, 5};
String[] names = {"Кукла", "Мяч", "Машинка", "Пазл", "Конструктор"};
double[] frequencies = {0.2, 0.3, 0.1, 0.2, 0.2};

PriorityQueue toysQueue = new PriorityQueue((t1,t2) ->
Double.compare(t2.getFrequency(), t1.getFrequency()));
for (int i = 0; i < ids.length; i++){
Toy toy = new Toy(ids[i], names[i], frequencies[i]);
toysQueue.add(toy);
}

List resultList = new ArrayList();
for (int i = 0; i < 10; i++) {
Toy currentToy = toysQueue.poll();
resultList.add(currentToy);
}

String fileName = "result.txt";
try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
for (Toy toy : resultList) {
writer.write(String.format("Id: %d, Название: %s, Частота выпадения: %.2fn",
toy.getid(), toy.getName(), toy.getFrequency()));
}
} catch (IOException e) {
System.err.format("IOException: %s%n", e);   
}
}
 
}