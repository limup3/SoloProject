import axios from 'axios'
import router from "@/router"

const state = {
    context: "http://localhost:5000/",
    bugsmusic: [],
    pl:[],
    count: 0
}

const actions = {
    async search({commit}, searchWord) {
        switch (searchWord) {
            case '벅스' :
                axios
                    .post(state.context + `bugsmusic`,searchWord, {
                        authorization: "JWT fefege..",
                        Accept: "application/json",
                        "Content-Type": "application/json"
                    })
                    .then(({data}) => {
                        commit("SEARCH",data)
                        router.push('/Music')
                    })
                    .catch(() => {
                        alert('통신실패!')
                    })
                break
            case '언어' :
                axios
                    .get(state.context+`pl/${searchWord}`)
                    .then(({data})=>{
                        alert('액션넘어옴')
                        commit("PL",data)
                        router.push("/PL")
                    })
                    .catch(() => {
                        alert('통신실패!')
                    })
                break
        }
    }
}

const mutations = {
    SEARCH(state, data) {
        alert("뮤데이션에서 결과 수 : " + data.count);
        state.bugsmusic = [];
        state.count = data.count;
        data.list.forEach(item => {
            state.bugsmusic.push({
                seq: item.seq,
                artist: item.artists,
                title: item.title,
                thumbnail: item.thumbnail
            });
        });
    },
    PL(state,data) {
        alert("뮤데이션에서 결과 수 : " + data.count);
        state.pl = [];
        state.count = data.count;
        data.list.forEach((item => {
            state.pl.push({
                thisyear: item.thisyear,
                lastyear: item.lastyear,
                changess: item.changess,
                pl: item.pl,
                rating: item.rating,
                changerating: item.changerating

            })
        }))
    }

};

const getters = {
    bugsmusic: state => state.bugsmusic,
    count: state => state.count,
    pl : state => state.pl
};

export default {
    name: 'crawling',
    namespaced : true,
    state,
    actions,
    mutations,
    getters
}