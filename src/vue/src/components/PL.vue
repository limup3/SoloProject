<template>
    <div>
        <h3 id="center">사랑받는 프로그래밍 언어 순위 TOP 20</h3>
        <div id="size"></div>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">Jun 2020</th>
                    <th class="text-left">Jun 2019</th>
                    <th class="text-left">Change</th>
                    <th class="text-left">Programming Language</th>
                    <th class="text-left">Ratings</th>
                    <th class="text-left">Change</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of pl" :key="item.thisyear">
                    <td>{{ item.thisyear }}</td>
                    <td>{{ item.lastyear }}</td>
                    <td><img :src="item.changess"></td>
                    <td>{{ item.pl }}</td>
                    <td>{{ item.rating }}</td>
                    <td>{{ item.changerating }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <!--            <div style="margin: 0 auto; width: 500px; height: 100px">-->
            <!--                <span v-if ='pager.existPrev' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">이전</span>-->
            <!--                <span v-for='i of pages' :key="i" style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">{{i}}</span>-->
            <!--                <span v-if ='pager.existNext' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">다음</span>-->
            <!--            </div>-->
            <!--            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>
</template>

<script>
    import { mapState } from "vuex";
    export default {
        data () {
            return {
                pageNumber: 0,
                existPrev : true,
                existNext : true,
                pages: [1,2,3,4,5],
                list: [],
                pager: {},
                totalCount: '',
            }
        },
        computed: {
            ...mapState({

                count: state => state.crawling.count,
                pl: state => state.crawling.pl

            })
        }

    }
</script>

<style scoped>
    #size {
        width: 150px;
        height: 40px;
    }
    #center {
        text-align: center;
    }
</style>