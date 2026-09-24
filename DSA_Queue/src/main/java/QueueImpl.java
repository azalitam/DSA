public class QueueImpl<E> implements Queue<E>{
    private E[] data;
    private int p; // Puntero contador de elementos que indica la siguiente posicion libre y no la actual

    public QueueImpl(int len) {
        // TO-DO
        this.data = (E[])new Object[len];
        this.p = 0; // He añadido esta línea para iniciar el puntero de la cola a 0

    }

    public void push(E e) throws FullQueueException {
        // TO-DO
        if (this.isFull()) {
            throw new FullQueueException();
        }
        this.data[this.p++]=e;
    }


    public E pop() throws EmptyQueueException {
        if (this.isEmpty()){
            throw new EmptyQueueException();
            // Comprueba si la cola esta vacía y si lo está llama a la función de EmptyQueueException
        }
        // Si no está vacía, guarda el primer elemento (el mas antiguo)
        E element = this.data[0];
        // Mueve todos los elementos una posición a la izquierda
        for (int i = 0; i < this.p -1; i++){
            this.data[i] = this.data[i + 1];
        }

        // reduce el contador
        this.p--;
        // devuelve el elemento
        return element;

    }

    private boolean isFull() {
        // TO-DO

        // Si el puntero iguala el tamaño del array está lleno
        return this.p == this.data.length;

    }

    private boolean isEmpty() {
        // TO-DO
        //Está vacia si el punterio está en 0
        return this.p == 0;
    }

    public int size() {
        //TO-DO
        return this.p;
    }
}
