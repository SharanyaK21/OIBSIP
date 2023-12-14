const celciusEl = document.getElementById("Celcius");
const fahrenheitEl = document.getElementById("Fahrenheit");


function computeTemp(event) {
    const currentValue = event.target.value;

    switch (event.target.name) {
        case "Celcius":
            fahrenheitEl.value = (currentValue * 9 / 5) + 32;
            kelvinEl.value = parseFloat(currentValue) + 273.15;
            break;

        case "Fahrenheit":
            celciusEl.value = (currentValue - 32) * 5 / 9;
            kelvinEl.value = (currentValue - 32) * 5 / 9 + 273.15;
            break;

        default:
            break;
    }
}