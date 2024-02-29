<template>
  <Header/>
  <div class="nav">
    <div class="back" @click="goToSignIn"></div>
    <div class="carcass">
      <p>
        Клиенты
      </p>
    </div>
  </div>
  <main>

    <div class="adress">
      <input type="button" value="Создать клиента" @click="togglePopup">
    </div>
      <CreateUserPopup v-if="showPopup" @close="showPopup = false"/>

      <div class="card-container">
        <div v-for="client in clients" :key="client.id">
          <div class="card" v-if="client" @click="goToClient(client.id)">{{ client.lastName }} {{ client.firstName }} {{ client.secondName }}</div>
        </div>
      </div>

  </main>
</template>

<script>
import CreateUserPopup from "@/components/CreateUserPopup.vue";
import Header from "@/components/Header.vue";
import axios from "axios";

export default {
  components: {
    CreateUserPopup,
    Header
  },
  data() {
    return {
      showPopup: false,
      clients: []
    };
  },
  mounted() {
    this.getClients()
  },
  methods: {
    togglePopup() {
      this.showPopup = !this.showPopup
    },
    saveAndRedirect() {
      alert("saveAndRedirect");
    },
    goToClient(id) {
      this.$router.push({ path: '/client/' + id });
    },
    goToSignIn() {
      this.$router.push({ name: 'signIn' });
    },
    async getClients() {
      await axios.get('http://localhost:8080/api/clients/by-user/' + this.$store.state.user[0].usersId.id)
          .then(response => {
            this.clients = response.data;
            console.log(response.data);
          })
          .catch(error => {
            console.error('Ошибка при получении списка клиентов', error);
          });

    }
  }
}
</script>

<style scoped>
@import '@/assets/style/carcas_page_style/style.css';
@import '@/assets/style/carcas_page_style/slide.css';
@import '@/assets/style/carcas_page_style/responsive.css';
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
</style>
