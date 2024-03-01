import React from 'react'
import styled from 'styled-components'

const Container = styled.div `
    height: 30px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
    font-weight: 500;
    background-color: #000000df;
    color: white;
`;

const NewsBoard = () => {
  return (
    <Container>
        Black Friday! Fino al 70% sui prodotti in catalogo!
    </Container>
  )
}

export default NewsBoard