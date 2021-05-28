<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <!-- <a v-b-modal.modal-login>Login</a> -->
      <b-button id="show-btn" @click="$bvModal.show('bv-modal-example')">Connexion</b-button>

    </div>


    <b-modal id="bv-modal-example" hide-footer>
      <template #modal-title>
        Connexion
      </template>
      <div class="d-block text-left">
        <!-- <b-form @submit="onSubmit" @reset="onReset"> -->
        <b-form>
          <!-- v-if="show" -->
          <b-form-group id="input-group-1" label="Nom d'utilisateur :" label-for="input-1">
            <b-form-input
              id="input-1"
              type="text"
              placeholder="Saisissez votre nom d'utilisateur"
              required
            ></b-form-input>
              <!-- v-model="form.username" -->
          </b-form-group>

          <b-form-group id="input-group-2" label="Mot de passe :" label-for="input-2">
            <b-form-input
              id="input-2"
              type="password"
              placeholder="Saisissez votre mot de passe"
              required
            ></b-form-input>
              <!-- v-model="form.password" -->
          </b-form-group>

          <div class="d-block text-right">
            <b-button type="submit" variant="primary">Valider</b-button>
          </div>
          <!-- <b-button type="reset" variant="danger">Reset</b-button> -->
        </b-form>
        
      </div>
      <!-- <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example')">Close Me</b-button> -->
    </b-modal>

    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
