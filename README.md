# TotalTracWSClient
Projeto WsClient para consumo do WS da TotalTrac - Rastreadora de veículos!

# Uso
O .war deve ser implantado em um servidor que suporte EJB e esteja com o Timer Service ativo.
A tabela representada pela classe org.linepack.model.Parametro.java deve ter ao menos uma linha ativa.
O controle do período requisitado é feito pela tabela representada na classe org.linepack.model.Requisicao.java.
O produto da requisicao ap WS é uma lista de org.linepack.model.Posicao.java, que é persistida no banco de dados logo após a requisicao.

# WSDL 
<a href="http://wsgslog.globalsearch.com.br/v20100/posicoes.asmx?WSDL">http://wsgslog.globalsearch.com.br/v20100/posicoes.asmx?WSDL</a>

# Ferramentas Utilizadas
<ul>
<li>Jpa 2.1</li>
<li>JAX-WS / JAXB</li>
<li>GlassFish 4.1.1</li>
<li>Oracle 10g</li>
</ul>



