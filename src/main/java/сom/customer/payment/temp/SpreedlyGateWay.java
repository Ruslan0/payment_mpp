package сom.customer.payment.temp;

public class SpreedlyGateWay {
    public Gateway gateway;

    public SpreedlyGateWay(){
    }

    public SpreedlyGateWay(Gateway gateway){
        this.gateway = gateway;
    }

    public static final class Gateway {

    	public String gateway_type;

        public Gateway(){
        }


        public Gateway(String gateway_type){
            this.gateway_type = gateway_type;
        }
    }
}