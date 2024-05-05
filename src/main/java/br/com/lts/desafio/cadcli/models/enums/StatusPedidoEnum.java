package br.com.lts.desafio.cadcli.models.enums;

public enum StatusPedidoEnum {

    NOVO(1,"Novo"),
    EM_PROCESSAMENTO(2,"Em Processamento"),
    AGUARDANDO_PAGAMENTO(3,"Aguardando Pagamento"),
    PAGAMENTO_APROVADO(4,"Pagamento aprovado"),
    PROBLEMA_COM_PAGAMENTO(5,"Problema com Pagamento"),
    EMITINDO_NOTA_FISCAL(6,"Emitindo Nota Fiscal"),
    ENVIADO_PARA_ENTREGA(7,"Enviado para entrega"),
    PEDIDO_ENTREGUE(8,"Pedido entregue"),
    PEDIDO_CONCLUIDO(9,"Pedido concluido"),
    PEDIDO_CANCELADO(10, "Pedido cancelado");

    private final int id;
    private String status;

    StatusPedidoEnum(int id, String descricao) {
        this.id = id;
        this.status = descricao;
    }

    public int getId(){
        return id;
    }

    public String getStatus(){
        return status;
    }

    public static StatusPedidoEnum getEnumById(int id){
        for(StatusPedidoEnum item : StatusPedidoEnum.values()){
            if(item.getId() == id){
                return item;
            }
        }
        throw new IllegalArgumentException("Id invalido para StatusPedidoEnum");
    }
}
