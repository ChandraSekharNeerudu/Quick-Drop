function calculateFee() {
    const distance = document.getElementById('distance').value;
    const weight = document.getElementById('weight').value;
    const basePrice = 50;
    
    if (distance > 0 && weight > 0) {
        // Logic: Base + (Dist * 5) + (Weight * 10)
        let total = basePrice + (distance * 5) + (weight * 10);
        
        document.getElementById('displayfee').innerText = total.toFixed(2);
        document.getElementById('packagefee').value = total.toFixed(2);
    } else {
        document.getElementById('displayfee').innerText = "0.00";
        document.getElementById('packagefee').value = "0";
    }
}