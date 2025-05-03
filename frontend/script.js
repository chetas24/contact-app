document.getElementById('singleContactForm').onsubmit = async function(e) {
    e.preventDefault();
    const form = e.target;
    const data = {
        name: form.name.value,
        phoneNum: form.phoneNum.value,
        birthday: form.birthday.value
    };
    const response = await fetch('http://localhost:8080/contacts', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    });
    const result = await response.json();
    document.getElementById('singleResult').innerText = result.message || JSON.stringify(result);
};