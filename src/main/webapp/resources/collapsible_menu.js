let button = document.getElementById("menu_button");

let menu = document.getElementById("dropdown_menu_container");

let isHovered = (el) => {
    return window.getComputedStyle(el).getPropertyValue('--hovered') == 1;
}

window.addEventListener("click", (event) => {
    if (menu.style.display == "none"){
        return;
    }
    if (!isHovered(menu)){
        console.log("Hide menu");
        menu.style.display = "none";
    }
})

button.addEventListener("click", (event) => {
    event.stopPropagation()
    // button.classList.toggle("active");

    if (menu.style.display === "block"){
        menu.style.display = "none";
        console.log("Close")
    }else{
        // setTimeout(function(){},20);
        menu.style.display = "block";
        console.log("Show")
    }
}, true)