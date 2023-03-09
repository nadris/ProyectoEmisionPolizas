package factoryRequest;

public class FactoryRequest {
    public static IRequest make (String requestType){
        IRequest request;

        switch (requestType.toLowerCase()){
            case "post":
                request = new RequestPOST();
                break;
            default:
                request= new RequestGET();
                break;
        }
        return request;
    }
}
