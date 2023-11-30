module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        'custom-fundo' : 'hsl(275, 30%, 57%)',
        'custom-font-destaque' : '#FFFFFF',
        'custom-font-secundario' : '#F6F1F1'
      },
      fontFamily: {
        'font-primaria': ['Roboto', 'sans-serif'],
        'font-secundaria': ['Poppins', 'sans-serif'],
      },
      screens: {
        'auto': {'max' : '1980px'},
        'desktop': { 'max': '1495px' },
        'laptop': {'max': '1024px'},
        'tablet': {'max': '640px'},
        'sm': {'max': '360px'},
      },
    },
  },
  plugins: [],
}
