
export default {
  setItem(key, value) {
    value = JSON.stringify(value);
    console.log(value)
    window.localStorage.setItem(key, value)
  },
  getItem(key, defaultValue) {
    let value = window.localStorage.getItem(key)
    try {
      value = JSON.parse(value);
    } catch {}
    return value || defaultValue
  },
  removeItem(key) {
    window.localStorage.removeItem(key)
  },
  clear() {
    window.localStorage.clear()
    localStorage.removeItem('vue_admin_template_token')
    let cookies = document.cookie.split(";");

    for (let i = 0; i < cookies.length; i++) {
      let cookie = cookies[i];
      let eqPos = cookie.indexOf("=");
      let name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
      document.cookie = name.trim() + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    }
  },
}
