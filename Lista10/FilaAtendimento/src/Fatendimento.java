import java.util.LinkedList;
import java.util.Queue;

public class Fatendimento {
    private Queue<Cliente> fClientes;
    private Funcionario[] funcionarios;

    public Fatendimento(int numFuncionarios) {
        fClientes = new LinkedList<>();
        funcionarios = new Funcionario[numFuncionarios];
        for(int i = 0; i < numFuncionarios; i++) {
            funcionarios[i] = new Funcionario(i + 1);
        }
    }

    public void addClientes(Cliente cliente) {
        fClientes.add(cliente);
        System.out.println("Cliente "+cliente.getId()+ " entrou na fila.");
        atenderCliente();
    }

    private void atenderCliente() {
        for(Funcionario funcionario : funcionarios) {
            if(!fClientes.isEmpty()) {
                Cliente cliente = fClientes.poll();
                System.out.println("Funcionário "+funcionario.getId()+" em atendimento ao cliente "+cliente.getId() +  
                 "\ntempo de atendimento: " + cliente.getTimeAtnd());

                 try {
                    Thread.sleep(cliente.getTimeAtnd() * 1000); // Convertendo unidades de tempo para milissegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Cliente " + cliente.getId() + " foi atendido pelo funcionário " + funcionario.getId());
            }
        }
    }


}
