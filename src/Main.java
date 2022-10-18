import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cart myQueue = new Cart(5);
        int choice;
        float percent;
        do {
            System.out.println("1. Добавить товар\n2. Удалить последний товар\n3. Проверить пустоту корзины\n4. Проверить полноту корзины\n5. Сумма всех товаров\n6. Повышение цен\n7. Понижение цен\n8. Содержимое корзины\n9. Выйти из программы");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    if (myQueue.isFull()) {
                        System.out.println("Корзина полная. Удалите последний товар");
                    }
                    else {
                        System.out.println("Введите название и цену товара: ");
                        Item item = new Item(in.next(), in.nextFloat());
                        myQueue.insert(item);
                        System.out.println("");
                    }
                    break;

                case 2:
                    myQueue.remove();
                    System.out.println("");
                    break;

                case 3:
                    if (myQueue.isEmpty()) {  //проверяем пуста ли queue
                        System.out.println("Корзина пуста");
                    }
                    else {
                        System.out.println("Корзина не пуста");
                    }
                    break;

                case 4:
                    if (myQueue.isFull()) {  //проверяем полная ли queue
                        System.out.println("Корзина полная");
                    }
                    else {
                        System.out.println("Корзина не полная");
                    }
                    break;

                case 5:
                    System.out.println("Сумма всех товаров: " + myQueue.calculateItemPrices());
                    System.out.println("");
                    break;

                case 6:
                    System.out.println("На сколько процентов хотите повысить цены? ");
                    percent = in.nextFloat();
                    myQueue.raiseItemPrices(percent);
                    break;

                case 7:
                    System.out.println("На сколько процентов хотите понизить цены? ");
                    percent = in.nextFloat();
                    myQueue.cutItemPrices(percent);
                    break;

                case 8:
                    if(myQueue.isEmpty()) {
                        System.out.println("Корзина пуста");
                    }
                    else {
                        myQueue.cartContents();
                    }
                    System.out.println("");
                    break;

                case 9:
                    System.out.println("Вы вышли");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Вы ввели неправильно. Попробуйте снова\n");
                    break;
            }
        } while(choice != 9);
    }
}