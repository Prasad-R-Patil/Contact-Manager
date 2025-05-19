const hamBurger = document.querySelector(".toggle-btn");

hamBurger.addEventListener("click", function () {
  document.querySelector("#sidebar").classList.toggle("expand");
});

function confirmLogout()
{
if(confirm("Are you sure want to logout?"))
{
    window.location.href="/logout";
}
}