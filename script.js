const display = document.getElementById("display");
const buttons = document.querySelectorAll("button");

buttons.forEach(button => {
    button.addEventListener("click", () => handleInput(button.innerText));
});

document.addEventListener("keydown", (e) => {
    if (
        (e.key >= 0 && e.key <= 9) ||
        "+-*/.%".includes(e.key)
    ) {
        handleInput(e.key);
    } else if (e.key === "Enter") {
        handleInput("=");
    } else if (e.key === "Backspace") {
        handleInput("⌫");
    } else if (e.key === "Escape") {
        handleInput("C");
    }
});

function handleInput(value) {
    if (value === "C") {
        display.value = "";
    } 
    else if (value === "⌫") {
        display.value = display.value.slice(0, -1);
    } 
    else if (value === "=") {
        try {
            if (display.value === "") return;
            display.value = eval(display.value);
        } catch {
            display.value = "Error";
            setTimeout(() => display.value = "", 1000);
        }
    } 
    else {
        display.value += value;
    }
}