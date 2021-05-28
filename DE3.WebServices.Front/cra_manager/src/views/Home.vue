<template>
    <div class="home">
      <b-container class="mt-2">
        <div class="d-block text-right">
          <label for="sb-inline">Numéro de semaine</label>
          <b-form-spinbutton id="sb-inline" v-model="week" inline></b-form-spinbutton>
        </div>
        <!-- <b-table striped hover :items="items" :fields="fields"> -->
        <b-table striped hover :items="items">
          <template v-slot:cell(projet)="row">
            <b-form-input v-model="row.item.projet"/>
          </template>
          <template v-slot:cell(lundi)="row">
            <b-form-input v-model="row.item.lundi"/>
          </template>
          <template v-slot:cell(mardi)="row">
            <b-form-input v-model="row.item.mardi"/>
          </template>
          <template v-slot:cell(mercredi)="row">
            <b-form-input v-model="row.item.mercredi"/>
          </template>
          <template v-slot:cell(jeudi)="row">
            <b-form-input v-model="row.item.jeudi"/>
          </template>
          <template v-slot:cell(vendredi)="row">
            <b-form-input v-model="row.item.vendredi"/>
          </template>
          <template v-slot:cell(samedi)="row">
            <b-form-input v-model="row.item.samedi"/>
          </template>
          <template v-slot:cell(dimanche)="row">
            <b-form-input v-model="row.item.dimanche"/>
          </template>
          <!-- <template slot="footer">
            <td>Total</td>
            <td>{{ totalLundi }}</td>
            <td>{{ totalMardi }}</td>
            <td>{{ totalMercredi }}</td>
            <td>{{ totalJeudi }}</td>
            <td>{{ totalVendredi }}</td>
            <td>{{ totalSamedi }}</td>
            <td>{{ totalDimanche }}</td>
          </template> -->
        </b-table>
        <table>
          <tr>
            <td>Total</td>
            <td id="totalLundi">{{ totalLundi }}</td>
            <td id="totalMardi">{{ totalMardi }}</td>
            <td id="totalMercredi">{{ totalMercredi }}</td>
            <td id="totalJeudi">{{ totalJeudi }}</td>
            <td id="totalVendredi">{{ totalVendredi }}</td>
            <td id="totalSamedi">{{ totalSamedi }}</td>
            <td id="totalDimanche">{{ totalDimanche }}</td>
          </tr>
        </table>

        <div class="d-block text-right">
          <b-button type="submit" variant="primary">Valider</b-button>
        </div>
        <br>
        {{ items }}
      </b-container>
    </div>
</template>

<style scoped>
table th, table td {
    padding: 0.75rem;
    vertical-align: top;
    border-top: 1px solid #dee2e6;
}

td {
    display: table-cell;
    vertical-align: inherit;
}

table {
    width: 100%;
    margin-bottom: 1rem;
    color: #212529;
    table-layout: fixed;
    border-collapse: collapse;
    text-indent: initial;
    border-spacing: 2px;
}

label{
  margin:10px;
}

</style>

<script>
  export default {
  data() {
    return {
      week: 21,
      fields: { Projet: "projet", Lundi: "lundi", Mardi: "mardi", Mercredi: "mercredi", Jeudi: "jeudi", Vendredi: "vendredi", Samedi: "samedi", Dimanche: "dimanche" },
      items: [
        {
          projet: "Projet 1",
          lundi: 1,
          mardi: 2,
          mercredi: 3,
          jeudi: 4,
          vendredi: 5,
          samedi: 6,
          dimanche: 7
        },
        {
          projet: "Projet 2",
          lundi: 0,
          mardi: 0,
          mercredi: 0,
          jeudi: 0,
          vendredi: 0,
          samedi: 0,
          dimanche: 0
        },
        {
          projet: "Projet 3",
          lundi: 0,
          mardi: 0,
          mercredi: 0,
          jeudi: 0,
          vendredi: 0,
          samedi: 0,
          dimanche: 0
        }
      ]
    }
  },
  computed: {
    totalLundi () {
      console.log('get lundi total')
      return this.items.reduce((acc, cur) => acc + Number(cur.lundi), 0);
    },
    
    totalMardi () {
      console.log('get mardi total')
      return this.items.reduce((acc, cur) => acc + Number(cur.mardi), 0);
    },
    
    totalMercredi () {
      console.log('get mercredi total')
      return this.items.reduce((acc, cur) => acc + Number(cur.mercredi), 0);
    },

    totalJeudi () {
      console.log('get jeudi total')
      return this.items.reduce((acc, cur) => acc + Number(cur.jeudi), 0);
    },

    totalVendredi () {
      console.log('get vendredi total')
      return this.items.reduce((acc, cur) => acc + Number(cur.vendredi), 0);
    },

    totalSamedi () {
      console.log('get samedi total')
      return this.items.reduce((acc, cur) => acc + Number(cur.samedi), 0);
    },

    totalDimanche () {
      console.log('get dimanche total')
      return this.items.reduce((acc, cur) => acc + Number(cur.dimanche), 0);
    }
  }
  // methods: {
  //   checkTotal () {
  //     console.log('check total of each column')
  //     return this.items.reduce((acc, cur) => acc + Number(cur.lundi), 0);
  //   }
    // getTotal () {
    //   console.log('method getting current total')
    //   return this.regions.reduce((acc, cur) => acc + Number(cur.lundi), 0);
    // },
    // updateDatabase(){
    //   console.log("update table with total: "+ this.totalCurrent());
    // }
  // }
      // };
    // }
  };

  // var lundi = document.getElementById("totalLundi").textContent;

  // console.log(lundi);
</script>

