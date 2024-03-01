
import React from 'react'
import styled from 'styled-components';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';

const NotebookContainer = styled.div `
    font-family: 'Ubuntu', sans-serif;
    background-color: rgb(255, 255, 255);
    border: 1px solid gray;
    border-radius: 10px;
    padding: 20px;
    margin: 10px;

    &:hover {
      box-shadow: 10px 10px 5px #dededeab;
      cursor: pointer;
    }
`
  const NotebookNameModel = styled.div `
    margin: 10px;
    font-size: 20px;
    font-weight: 600;

  `;

  const NotebookInfos = styled.div `
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    margin: 10px;
    
  `;

  const ImageContainer = styled.div `
    flex: 1;
  `;



  const NotebookTechnicalsInfo = styled.div `
    flex: 1;
  `;

  const NotebookField = styled.div `
    margin: 10px;
  `;

  const NotebookPrice = styled.div `
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  `;

  const BuyButton = styled.button `
    display: flex;
    justify-content: space-between;
    margin-top: 200px;
    padding: 12px;
    font-size: 18px;
    font-weight: 600;
    background-color: black;
    color: white;
    border-radius: 4px;
    border: 1px solid black;
    cursor: pointer;
  `;

  const InfoTitle = styled.div `
    font-size: 12px;
    color: rgb(0,0,0);
    font-weight: 400px;
  `;

  const Info = styled.div `
    font-size: 14px;
    color: rgb(58,58,58);
    font-weight: 600;
  `;

    const PriceBox = styled.div `
    margin-bottom: 5px;
    `;

    const PriceTitle = styled.div `
      font-weight: 600;
      color: rgb(58, 58, 58);
      font-size: 18px;
    `;

    const Price = styled.div `
      color: rgb(223, 0, 0);
      font-size: 24px;
    `;


    const Consegna = styled.div `
      color: rgb(58, 58, 58);
      font-size: 10px;
    `;



const Notebook = ( {notebook } ) => {
  return (
    <NotebookContainer>
      <NotebookNameModel>{notebook.nameModel}</NotebookNameModel>
      <NotebookInfos>
        <ImageContainer>
          <img className='notebook-image' src={notebook.uriImage} alt="computer" />
        </ImageContainer>
        <NotebookTechnicalsInfo>
          <NotebookField>
            <InfoTitle>Processore</InfoTitle>
            <Info>{notebook.cpu}</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Dimensione memoria RAM</InfoTitle>
            <Info>{notebook.ram}</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Capacità di memorizzazione totale in GB</InfoTitle>
            <Info>{notebook.storage} GB</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Sistema Operativo</InfoTitle>
            <Info>{notebook.operatingSystem}</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Marca</InfoTitle>
            <Info>{notebook.brand}</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Scheda Grafica</InfoTitle>
            <Info>{notebook.gpu}</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Tipo di memoria</InfoTitle>
            <Info>{notebook.disk}</Info>
          </NotebookField>
          <NotebookField>
            <InfoTitle>Grandezza dello schermo</InfoTitle>
            <Info>{notebook.screenSize} pollici</Info>
          </NotebookField>
        </NotebookTechnicalsInfo>
        <NotebookPrice>
          <PriceBox>
            <PriceTitle>Prezzo:</PriceTitle>
            <Price>{notebook.price}</Price>
          </PriceBox>
          <Consegna>
            Per modalità e tempi di consegna, contattare il venditore, SmartSearch non si assume alcune responsabilità sulle modalità di consegna del prodotto.
          </Consegna>
          <BuyButton>Aggiungi al carrello <ShoppingCartIcon/></BuyButton>
        </NotebookPrice>
      </NotebookInfos>
    </NotebookContainer>
  )
}

export default Notebook