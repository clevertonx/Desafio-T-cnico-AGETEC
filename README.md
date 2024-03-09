# Desafio-T-cnico-AGETEC
Desafio técnico proposto pela AGETEC (JAVA)

Para atendimento as necessidades da Agência Municipal de Transporte e Trânsito, foi desenvolvido o sistema de
controle de multas – SICOM WEB, tal sistema se baseia na importação e processamento de arquivos disponibilizados pelo DETRAN
MS e empresas terceirizadas, sendo assim, se faz necessário a migração de determinados arquivos do servidor dessas instituições
para os servidores da Agência Municipal de Tecnologia da Informação – AGETEC, além do processamento desses arquivos para
inclusão dos dados em nossa base.
Solicitamos a implementação de uma rotina em JAVA, capaz de identificar arquivos de extensão .csv com informações de condutores
(Nome, CPF e placa do veículo). Essa rotina deve copiar esses arquivos de uma pasta para outra, acessar o conteúdo desses
arquivos, popular um objeto e em atendimento a Lei Geral de Proteção de Dados – LGPD, deve imprimir no console apenas as
iniciais do nome e os três primeiros dígitos do CPF do condutor.

Segue exemplo do que se espera como entrada e saída de dados:

Entrada: Nome, CPF, Placa do veículo
Gustavo Alves da Silva, 020.056.080-44, HQW-5234

Saída: 
Nome: G. A. D. S
CPF: 020.***.***-**



Realizei o desafio adotando o padrão de projeto Strategy.
