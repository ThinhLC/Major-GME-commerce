var checkbox_toggle = document.getElementById('light-dark');
checkbox_toggle.addEventListener('change', function (){
    //Add dark theme for bpdy
    document.body.classList.toggle('dark')
})