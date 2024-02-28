<template>
  <Header :client="this.id" :clientData="clientData"/>
  <div class="nav">
    <div class="back"  @click="backToSignIn"></div>
    <div class="carcass">
      <p>
        Карточка клиента
      </p>
    </div>
  </div>

  <main>
    <form action="">
      <div class="create-calculation-button">
        <input type="button" style="cursor: pointer;" value="Создать расчет" @click="togglePopup">
        <ConstructionElementPopup v-if="showPopup" @close="showPopup = false"/>
      </div>
    </form>
    <div class="client-bg">
    <hr>
    

    <div class="client">
      <div class="calculation">
        <div class="container"> <div> Расчет №2 </div> </div>
        <div class="container"> <div> 02.02.2021 </div> </div>
        <div class="container"> <div> Актуален </div> </div>
        <div class="container"> <div> Адрес <br> строительства </div> </div>
      </div>
      <div class="buttons">
        <div class="copy">
          <img src="@/assets/img/copy.png" alt="">
        </div>
        <div class="delete">
          <img src="@/assets/img/delete.png" alt="">
        </div>
      </div>

    </div>
    <hr>
    </div>
  </main>
</template>

<script>
import ConstructionElementPopup from "@/components/ConstructionElementPopup.vue";

export default {
  components: {
    ConstructionElementPopup
  },
  props: {
    id: String
  },
  data() {
    return {
      showPopup: false,
      clientData: true,
      client: Object,
      calculations: [{}]
    };
  },
  async mounted() {
    await axios.get('http://localhost:8080/api/clients/' + this.id).then(response => { this.client = response.data; }).catch(error => { alert('Ошибка при получении данных клиента', error); });
    await axios.get('http://localhost:8080/api/calculations/by-customer/' + this.id)
        .then(response => { this.calculations = response.data; console.log(this.calculations);})
        .catch(error => { alert('Ошибка при получении данных расчетов', error); });
  },
  methods: {
    togglePopup() {
      this.showPopup = !this.showPopup
    },
    saveAndRedirect() {
      alert("saveAndRedirect");
    },
    backToSignIn() {
      this.$router.push({ name: "clientsPage" });
    },
    copyCalculation(id) {
      console.log("copy " + id);
    },
    deleteCalculation(id) {
      console.log("delete " + id);
    }
  }
}
</script>

<style scoped>
@import '../assets/style/carcas_page_style/style.css';
@import '../assets/style/carcas_page_style/slide.css';
@import '../assets/style/carcas_page_style/responsive.css';
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
</style>
