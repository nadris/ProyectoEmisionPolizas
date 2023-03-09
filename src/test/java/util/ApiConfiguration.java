package util;

public class ApiConfiguration {

    public static final String SEARCH_PERSON=GetProperties.getInstance().getHost()+"/api/CrdWsCliente/?numeroDocumento=%s&tipoPersona=N";
    public static final String CREATE_AND_UPDATE_CLIENT=GetProperties.getInstance().getHost()+"/api/CrdWsCliente/PostRegistrarActualizarCliente";
    public static final String REGISTER_POLICY=GetProperties.getInstance().getHost()+"/api/CrdWsPoliza";
    public static final String OBTAIN_DOCUMENT_POLICY=GetProperties.getInstance().getHost()+"/api/CrdWsCredinform/PdfPolizaCompleta?codusuario=kieffer.lp&codpoliza=%s&idproducto=CA&idsubrogacion=1&idopcionpdf=4";
}
