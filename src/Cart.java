public class Cart {
    private Item[] queue; //массив для хранения элементов queue
    private int front; //front указывает на передний элемент в queue
    private int rear;  //задняя часть указывает на последний элемент в queue
    private int count;   //текущий размер queue
    private int capacity; // максимальное количество элементов в очереди

    public Cart(int capacity) { //конструктор для инициализации queue
        this.capacity = capacity;
        queue = new Item[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public Item remove() { //удаление элемента
        Item tmp = queue[front++]; //получаем первый элемент из очереди
        if (front == capacity) { //циклический перенос
            front = 0;
        }
        capacity--;
        return tmp; //уменьшаем количество элементов в очереди
    }

    public void insert(Item Item) { //вставка элемента
        if (rear == capacity - 1) {  //циклический перенос
            rear = -1;
        }
        queue[++rear] = Item;  //увеличение Rear и вставка
        count++;  //увеличение количества элементов в очереди
    }

    public Item peek() { //вспомогательная функция для возврата первого элемента queue
        if (isEmpty()) {
            System.out.println("В корзине пусто\nПрограмма останавливается");
            System.exit(-1);
        }
        return queue[front];
    }

    public Item getFront() {
        return queue[front];
    }

    public Item getRear() {
        return queue[rear];
    }
    public int count() { //вспомогательная функция для возврата размера queue
        return count;
    }

    public boolean isEmpty() { //вспомогательная функция для проверки, пуста ли queue или нет
        return (count() == 0);
    }

    public boolean isFull() { //вспомогательная функция для проверки того, заполнена ли queue или нет
        return (count() == capacity - 1);
    }

    public float calculateItemPrices() { //сумма всех товаров
        float sum = 0;
        for(int i = 0; i <= rear; i++) {
            sum = sum + queue[i].getPrice();

        }
        return sum;
    }

    public void cartContents() { //содержимое корзины
        for(int i = 0; i <= rear; i++) {
            System.out.println("Товар: " + queue[i].getName() + ". Цена: " + queue[i].getPrice());
        }
    }

    public void raiseItemPrices(float percent) { //повышение цен на некоторый процент
        for(int i = 0; i <= rear; i++) {
            queue[i].priceIncrease(percent);
        }
        System.out.println("");
    }

    public void cutItemPrices(float percent) { //снижение цен на некоторый процент
        for(int i = 0; i <= rear; i++) {
            queue[i].priceDrop(percent);
        }
        System.out.println("");
    }
}