import React from 'react'
import styled from 'styled-components'
import AppStore from '../images/app-store.png'
import PlayStore from '../images/play-store.png'
import LogoImage from '../images/logo2.jpeg'
import Facebook from '@mui/icons-material/Facebook';
import Instagram from '@mui/icons-material/Instagram';
import Twitter from '@mui/icons-material/Twitter';


const Container = styled.div`
    background: #000;
    color: #8a8a8a;
    font-size: 15px;
    padding: 60px 0 20px;
`;

const FooterRow = styled.div`
    display: flex;
    justify-content: space-between;
`;

const AppLinks = styled.div`
    margin-left: 15px;
    min-width: 250px;
    margin-bottom: 20px;
    flex-basis: 20%;
`;

const Logo = styled.div`
    color: white;
    text-align: center;
`;

const UsefulLinks = styled.div`
    min-width: 250px;
    margin-bottom: 20px;
`;

const SocialMediaLinks = styled.div`
    min-width: 250px;
    margin-bottom: 20px;
    margin-right: 15px;
`;

const AppLogo = styled.div`
    margin-top: 20px;
`;


const Image = styled.img`
    width: 100px;
    margin-top: 10px;
    margin-right: 5px;
`;

const SocialIcon = styled.div `
    width: 20px;
    height: 20px;
    color: white;
`;


const Footer = () => {
  return (
    <Container>
        <FooterRow>
            <AppLinks>
                <h3 className='footer-h3'>Scarica la nostra App</h3>
                <p className='footer-p'>Download app for Android and IOS smartphone</p>
                <AppLogo>
                    <Image src={AppStore}/>
                    <Image src={PlayStore}/>
                </AppLogo>
            </AppLinks>
            <Logo>
                <h1>SMARTSEARCH</h1>
                <Image src={LogoImage}/>
            </Logo>
            <UsefulLinks>
                <h3 className='footer-h3'>Useful Links</h3>
                <ul>
                    <li className='footer-usefulLink'>Coupons</li>
                    <li className='footer-usefulLink'>Blog Post</li>
                    <li className='footer-usefulLink'>Return Policy</li>
                    <li className='footer-usefulLink'>Join Affiliate</li>
                </ul>
            </UsefulLinks>
            <SocialMediaLinks>
                <h3 className='footer-h3'>Seguici sui Social Networks</h3>
                <ul>
                    <li className='footer-socialLink'>Facebook <SocialIcon><Facebook/></SocialIcon></li>
                    <li className='footer-socialLink'>Instagram <SocialIcon><Instagram/></SocialIcon></li>
                    <li className='footer-socialLink'>Twitter <SocialIcon><Twitter/></SocialIcon></li>
                </ul>
            </SocialMediaLinks>
        </FooterRow>

    </Container>
  )
}

export default Footer