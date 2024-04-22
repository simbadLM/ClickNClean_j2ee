
const connectForm = document.getElementById("connectionForm");


function registerCleaner() {
    document.getElementById("mainContent").innerHTML = 
        "<div id='RegistrationForm'>"
        +   "<h1>Inscription comme Cleaner</h1>"
        +   "<form method='post' action='http://localhost:9090/clickNclean_j2ee/register'>"
        +       "<input class='inputFieldRegC type='text' name='lastname' placeholder='Nom' required>"
        +       "<input class='inputFieldRegC type='text' name='fistname' placeholder='Prénom' required>"
        +       "<input class='inputFieldRegC type='password' name='rawPwd' placeholder='Saisissez un mot de passe' required>"
        +       "<input class='inputFieldRegC type='password' name='rawConfirmedPwd' placeholder='Confirmez votre mot de passe' required>"
        +       "<input class='inputFieldRegC type='text' name='mail' placeholder='E-mail' required>"
        +       "<input class='inputFieldRegC type='text' name='phone' placeholder='Téléphone' required>"
        +       "<input class='inputFieldRegC type='date' name='birth' required>"
        +       "<input class='inputFieldRegC type='text' name='label' placeholder='Type et nom de la voie' required>"
        +       "<input class='inputFieldRegC type='text' name='houseN' placeholder='Numéro d'immeuble ou maison' required>"
        +       "<input class='inputFieldRegC type='text' name='postcode' placeholder='Code postal' required>"
        +       "<input class='inputFieldRegC type='text' name='city' placeholder='Ville' required>"
        +       "<input class='inputFieldRegC' type='text' name='range' placeholder='Rayon de recherche en Km souhaité' required>"
        +       "<textarea class='inputFieldRegC' name='bio' placeholder='Parlez de vous à vos clients' required></textarea>"
        +       "<caption>Quel expérience avez-vous ?</caption>"
        +       "<select class='inputFieldRegC' name='exp' required>"
        +            "<option value='' >--Merci de choisir option--</option>"
        +           "<option value='0'>Aucune</option>"
        +           "<option value='<1' >Moins d'un an</option>"
        +           "<option value='3<1' >Entre 1 et 3 ans</option>"
        +           "<option value='>3' >Plus de 3 ans</option>"
        +       "</select>"
        +       "<input class='buttonReg' type='submit' value='JE M'INSCRIS'>"
        +   "</form>"
        +   "</div>"
};



function registerOwner() {
    document.getElementById("mainContent").innerHTML = 
            "<div id='RegistrationForm'>"
            +   "<h1>Inscription comme Tidy-seeker</h1>"
            +   "<form method='post' action='http://localhost:9090/clickNclean_j2ee/register'>"
            +       "<input class='inputFieldReg' type='text' name='lastname' placeholder='Nom' required>"
            +       "<input class='inputFieldReg' type='text' name='fistname' placeholder='Prénom' required>"
            +       "<input class='inputFieldReg' type='password' name='rawPwd' placeholder='Saisissez un mot de passe' required>"
            +       "<input class='inputFieldReg' type='password' name='rawConfirmedPwd' placeholder='Confirmez votre mot de passe' required>"
            +       "<input class='inputFieldReg' type='text' name='mail' placeholder='E-mail' required>"
            +       "<input class='inputFieldReg' type='text' name='phone' placeholder='Téléphone' required>"
            +       "<caption for='service'>Quel type de prestation recherchez-vous ?</caption>"
            +       "<select class='inputFieldReg' name='service' required>"
            +           "<option value='' >--Merci de choisir une option--</option>"
            +           "<option value='guestRoom' >Ménage de location de courte durée</option>"
            +           "<option value='mainHome' >Résidence principale</option>"
            +           "<option value='inventory' >État des lieux</option>"
            +       "</select>"
            +       "<input class='buttonReg' type='submit' value='JE M'INSCRIS'>"
            +   "</form>"
            +"</div>"
}