Fila/Queue São estruturas de dados lineares que representam nossas filas do dia a dia, ou seja, fila de banco, do
supermercado, do cinema, etc. Filas são muito usadas em sistemas de agendamento e processamento assíncrono. O algoritmo
que as define é o FIFO (First-In-First-Out), isto é, "o primeiro a chegar é o primeiro a ser atendido".

Suas principais operações são: enqueue(e) - insere um elemento no início da fila; dequeue - remove o primeiro elemento;
peekFirst - acessa o primeiro elemento (próximo à saída); peekLast - acessa o último elemento (próximo à entrada da
fila).

```Java
class QueueDemo {
    public static void main(String[] args) {
        Queue<String> bankline = new ArrayDeque<>();
        bankline.add("Java");
        bankline.add("Algoritmos");
        bankline.add("Estruturas de Dados");
        System.out.println("Topo: " + bankline.peek());
        String collect = String.join(", ", bankline);
        System.out.println("Todos: " + collect);
        System.out.println("poll(): " + bankline.poll());
        System.out.println("poll(): " + bankline.poll());
        System.out.println("poll(): " + bankline.poll());
    }
}
```

![img.png](600px-Data_Queue.svg.png)


Complexidade Big O

Acessar: O(n)
Buscar: O(n)
Inserir: O(1)
Excluir: O(1)

# Código da fila feito com array
