
public class HackSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();

		int[] sortList = { 7103, 9482, 3869, 3914, 3180, 4413, 9100, 5923, 2581, 3535, 1719, 9320, 748, 5627, 5921,
				6398, 1040, 7862, 7342, 7136, 7775, 2675, 5127, 6922, 4268, 8015, 656, 6779, 453, 856, 4886, 9648, 1158,
				5518, 8338, 9311, 1661, 5252, 8114, 9579, 3085, 3510, 3882, 865, 7964, 7458, 6266, 194, 5340, 6268,
				4663, 5600, 6340, 3306, 5369, 4329, 145, 4260, 4675, 1349, 7933, 8284, 5320, 3756, 1894, 8295, 6724,
				7249, 4028, 833, 1370, 6906, 1708, 2697, 7405, 8082, 6758, 1745, 2317, 237, 1256, 4854, 1476, 1446,
				4178, 8244, 135, 2433, 3603, 2021, 342, 9143, 7185, 4386, 517, 3160, 480, 3335, 8965, 5654, 4577, 9326,
				8723, 9048, 3290, 9229, 5867, 3900, 2543, 9413, 1166, 7493, 1181, 5646, 976, 3981, 2642, 5167, 3254,
				8257, 1004, 8399, 4916, 3083, 5031, 8932, 8453, 3340, 1682, 9972, 8536, 475, 7486, 2937, 4196, 7751,
				3812, 8943, 4023, 2232, 7860, 9188, 8860, 894, 1377, 7018, 9424, 5307, 9416, 1730, 9033, 9436, 7268,
				3598, 5497, 9698, 2204, 6092, 5839, 9616, 5991, 5126, 5503, 8258, 2568, 52, 2422, 9524, 8280, 7238,
				9734, 5079, 7294, 9733, 6557, 7102, 4506, 9043, 1159, 2164, 3059, 2657, 2623, 2265, 8003, 3858, 1187,
				7720, 8694, 6991, 6295, 6970, 8377, 4823, 8174, 2145, 9252, 933, 905, 4803, 9011, 2627, 4503, 5998,
				6194, 2122, 3942, 565, 8041, 9997, 9730, 4812, 2804, 6251, 7574, 9086, 8404, 3835, 7716, 1201, 7529,
				8321, 9077, 7848, 3493, 1913, 5343, 1277, 6329, 5871, 9681, 409, 7474, 6313, 2640, 6938, 9504, 5630,
				1505, 4358, 2756, 666, 288, 7303, 6688, 3126, 6287, 8646, 4855, 2892, 9933, 2576, 3553, 3070, 564, 7392,
				2575, 414, 5536, 158, 8729, 8092, 6845, 616, 264, 8030, 4700, 4240, 5032, 4835, 2392, 140, 4275, 6608,
				1513, 9394, 2083, 2909, 2350, 1384, 779, 1100, 5524, 8125, 9454, 3629, 934, 5920, 895, 6705, 8347, 2031,
				7465, 6770, 1294, 241, 4177, 7885, 9265, 5379, 1658, 7340, 6310, 7469, 7729, 495, 6307, 6722, 8666,
				6303, 4253, 6469, 7462, 5366, 8879, 4409, 3256, 3709, 4607, 2659, 7851, 1240, 2187, 4245, 8575, 8042,
				4276, 6173, 3087, 1777, 3788, 9517, 6429, 3392, 2768, 2569, 178, 8568, 5661, 9962, 5881, 5732, 89, 5966,
				5792, 5713, 2087, 1322, 1904, 9910, 1595, 6150, 732, 1284, 1068, 4193, 2293, 3526, 7473, 3875, 2276,
				5082, 6599, 3113, 2347, 6093, 5055, 3211, 3102, 8262, 4638, 3383, 9172, 7477, 6129, 7455, 3239, 2831,
				2417, 1769, 4647, 2828, 8434, 3249, 4463, 7840, 9820, 3862, 9539, 69, 6005, 721, 5895, 5958, 720, 4421,
				5357, 731, 2667, 467, 5684, 6405, 5950, 4910, 3179, 9893, 1553, 3202, 3233, 7147, 2416, 1987, 4513,
				5831, 955, 6003, 7065, 8425, 4856, 7535, 3783, 6136, 716, 8649, 2327, 2242, 4435, 376, 6522, 5454, 7004,
				6626, 2093, 5478, 1816, 2876, 8094, 588, 3033, 2285, 8264, 4903, 8612, 2644, 7034, 8095, 4418, 8463,
				457, 406, 9563, 4088, 8616, 152, 9663, 4895, 2680, 3448, 3591, 6001, 4849, 3136, 3010, 8743, 7771, 4344,
				8867, 8444, 2983, 7978, 6752, 9059, 1469, 8887, 9054, 3888, 8716, 1731, 7783, 1576, 3183, 2424, 285,
				3062, 2363, 8389, 8160, 7286, 8159, 8678, 6221, 5854, 4796, 1766, 2337, 5567, 7140, 2520, 6693, 8596,
				7219, 6823, 9889, 6407, 8786, 8026, 4379, 5360, 4579, 5485, 4759, 3441, 7412, 4405, 2805, 7722, 2529,
				9961, 866, 1923, 1119, 8403, 2564, 9278, 5092, 444, 852, 9841, 2854, 2186, 8428, 3289, 9673, 9261, 9368,
				6553, 2798, 3956, 8465, 9235, 5617, 8625, 531, 1842, 1337, 6649, 8451, 8500, 147, 7085, 2616, 7867,
				8212, 5521, 148, 7002, 1018, 4249, 8341, 6091, 3609, 738, 5542, 2005, 7028, 7921, 7378, 9207, 1053,
				4704, 6381, 763, 1458, 9063, 7025, 7715, 5924, 8872, 4842, 9426, 259, 3643, 9944, 5913, 86, 3006, 9445,
				1648, 6414, 3067, 679, 7200, 8087, 6832, 5068, 8832, 176, 3845, 9318, 8472, 7270, 1042, 4755, 4676,
				6264, 9803, 3188, 3879, 2695, 390, 6345, 4041, 3604, 1918, 8685, 3348, 6893, 1399, 2774, 862, 1884,
				3754, 8044, 2054, 8930, 5112, 2735, 9556, 3360, 5562, 6338, 9360, 5203, 9617, 9209, 1940, 3005, 4543,
				8587, 8167, 3090, 1444, 347, 1010, 5828, 6365, 9003, 9174, 5729, 164, 1142, 3182, 4066, 4478, 7826,
				1186, 7374, 6021, 1324, 7656, 949, 7135, 4190, 8746, 2869, 7628, 6812, 754, 533, 2886, 3712, 4213, 9719,
				3620, 2010, 5460, 1813, 2138, 5025, 8856, 8373, 7312, 7173, 3662, 2713, 8547, 7955, 2850, 5394, 898,
				2648, 9131, 5439, 9508, 9271, 3079, 1888, 4279, 6200, 6439, 6228, 7806, 6169, 1581, 8227, 705, 1528,
				3915, 5581, 9505, 7011, 2683, 2211, 8502, 8780, 521, 3523, 2514, 1807, 7044, 67, 1499, 5207, 7627, 9634,
				4499, 5613, 8639, 8524, 7856, 8976, 9180, 4105, 6437, 5720, 9058, 4783, 6177, 690, 9509, 3198, 4272,
				8529, 2826, 3024, 8863, 9952, 3217, 4933, 9258, 9798, 4752, 8628, 142, 6153, 2287, 6133, 3465, 9317,
				5680, 7318, 6422, 5191, 9553, 1908, 190, 5119, 2583, 5050, 1977, 7606, 2152, 9724, 6781, 4078, 7935,
				2691, 1901, 6293, 4941, 5405, 63, 7711, 8435, 8722, 8102, 128, 5878, 2820, 1260, 3816, 1203, 2741, 7865,
				2792, 5097, 5067, 2288, 7338, 2029, 6795, 1981, 2631, 4937, 7457, 6587, 6967, 242, 7193, 889, 6748,
				4015, 4927, 8314, 6772, 1137, 5128, 6181, 6479, 1821, 596, 6929, 2989, 3025, 8291, 6314, 3187, 4773,
				214, 7261, 9123, 7649, 757, 4517, 2671, 2600, 1103, 6196, 8975, 472, 7827, 7966, 7883, 7160, 953, 2427,
				3552, 3130, 2487, 9039, 6071, 5310, 1002, 7507, 9295, 3201, 3307, 3899, 9383, 9699, 7256, 3200, 842,
				2421, 6562, 9226, 6808, 6527, 3358, 4149, 165, 5963, 3199, 8585, 937, 5696, 1771, 3497, 5935, 240, 906,
				6560, 3537, 1165, 3475, 4310, 3356, 9409, 6577, 7170, 8450, 1646, 2970, 9683, 6986, 2295, 5017, 2800,
				3802, 3315, 5548, 6242, 8581, 7590, 7575, 4530, 6971, 5526, 7304, 4833, 3470, 9313, 2619, 4694, 9548,
				9367, 662, 3560, 5285, 615, 8415, 9603, 7822, 1815, 3753, 9268, 6671, 3237, 4442, 4844, 5423, 369, 8961,
				9282, 9646, 526, 4793, 1237, 9349, 2015, 3618, 6609, 2560, 4832, 6058, 6068, 6984, 7479, 2587, 9722,
				6225, 6152, 7126, 8484, 6396, 2586, 8488, 3551, 2262, 4570, 1083, 7363, 837, 942, 5273, 6289, 2496,
				5978, 8052, 687, 6099, 7322, 3558, 9280, 7539, 5105, 5771, 8661, 768, 4493, 7691, 5929, 7104, 1597,
				3189, 1113, 1473, 3109, 4858, 4019, 6631, 984, 8798, 2310, 3513, 455, 9381, 9477, 3826, 6148, 3031,
				8909, 6750, 8210, 5962, 1872, 9602, 9183, 1289, 8366, 2638, 1922, 2169, 1029, 4128, 1267, 2197, 9785,
				8800, 8186, 3883, 8219, 4950, 5745, 3013, 8133, 8190, 1650, 4792, 4837, 4690, 9716, 7297, 1993, 7112,
				6868, 541, 8828, 5433, 1835, 2000, 7209, 3026, 3321, 8496, 7310, 4191, 5766, 1985, 5019, 72, 6796, 4244,
				3735, 122, 9385, 9657, 6468, 327, 6542, 8183, 7549, 3466, 1172, 7799, 6777, 3473, 9452, 2521, 602, 1338,
				3663, 8885, 5318, 4686, 6743, 6483, 8276, 29, 7506, 4445, 7134, 500, 964, 9301, 7138, 2757, 1688, 8954,
				2330, 3912, 4575, 774, 4521, 5945, 7879, 6787, 2873, 4204, 4397, 7852, 4801, 9639, 1534, 549, 1709,
				4710, 9688, 6054, 9850, 7273, 9762, 6720, 5409, 6529, 874, 3919, 1425, 1955, 8271, 3628, 9464, 2342,
				4562, 9082, 4960, 4188, 7515, 4723, 1356, 5098, 2908, 8559, 183, 9270, 2313, 2845, 305, 6995, 3393,
				2658, 678, 2567, 9272, 2434, 5556, 2613, 6973, 8420, 9788, 7369, 5678, 2325, 2206, 7991, 7548, 7361,
				7411, 2770, 8312, 5685, 6085, 4624, 3601, 742, 7288, 7050, 4423, 7971, 1619, 7218, 7356, 5671, 3917,
				8527, 7540, 6883, 9950, 7986, 8517, 3961, 9742, 7516, 4297, 9443, 3947, 6376, 4129, 8482, 1389, 6000,
				5501, 2277, 9225, 2153, 7932, 8924, 909, 1504, 471, 4380, 1786, 7605, 4526, 6821, 1154, 2544, 499, 2374,
				7394, 3388, 5824, 2632, 7041, 9606, 4456, 872, 3707, 5144, 649, 1829, 888, 6466, 370, 6233, 5914, 4797,
				7298, 9947, 1753, 5209, 2085, 4659, 2653, 8073, 2058, 6162, 2323, 33, 1230, 8952, 9573, 6302, 9870,
				3979, 5598, 8018, 1938, 8211, 4728, 5742, 5248, 1897, 9212, 2579, 2950, 341, 6377, 2117, 512, 8822,
				1659, 6897, 6451, 3665, 2432, 9306, 59, 4923, 2861, 1511, 5346, 8129, 9940, 9169, 9858, 3171, 7609,
				7043, 115, 8902, 5259, 6222, 4073, 4387, 5404, 9984, 6818, 9099, 8209, 8019, 8512, 2420, 5247, 8686,
				3205, 7510, 6645, 8057, 7843, 9951, 5451, 9601, 9440, 1497, 7773, 4762, 2976, 947, 7872, 1590, 7333,
				8980, 1405, 1179, 2785, 8253, 5183, 2485, 3460, 4250, 8945, 4282, 677, 1132, 3336, 4113, 9727, 8644,
				6123, 3926, 9101, 2399, 6416, 3166, 7177, 1243, 9114, 1516, 8950, 981, 1167, 2101, 8882, 256, 8580, 130,
				7141, 5557, 2875, 8352, 4814, 3318, 4045, 85, 1968, 6202, 2762, 137, 903, 7456, 7060, 9670, 4148, 141,
				7442, 6946, 1209, 958, 1608, 3471, 7949, 9750, 1089, 9444, 7226, 9105, 784, 428, 3750, 2651, 2928, 3893,
				4643, 2867, 5587, 5160, 2020, 1756, 1936, 1691, 4402, 1359, 8136, 9537, 7723, 7133, 6066, 6912, 8789,
				1617, 8106, 9672, 6914, 7285, 1190, 5955, 2039, 331, 7936, 7233, 2146, 4716, 7466, 7648, 8250, 3922,
				744, 9996, 9695, 8116, 2607, 4469, 2527, 1129, 2116, 1484, 6882, 4328, 1357, 1170, 1797, 4284, 8849,
				1587, 5853, 5760, 6568, 9567, 4893, 5008, 8011, 7480, 5240, 7564, 4171, 9836, 1882, 6742, 6183, 880,
				540, 5663, 9177, 6521, 5374, 3934, 4859, 9937, 6813, 2041, 9823, 6692, 8515, 245, 5331, 7463, 2453, 162,
				9056, 4764, 4422, 1563, 299, 4143, 5508, 4934, 5563, 1406, 4655, 92, 3572, 2634, 6620, 5819, 8322, 4315,
				1792, 5972, 8992, 3884, 2746, 8278, 1178, 4103, 156, 5102, 4290, 498, 4881, 4968, 684, 5916, 2566, 1535,
				7780, 6140, 3953, 4868, 1424, 1703, 2833, 4159, 1481, 4141, 508, 5077, 7343, 7788, 7441, 7876, 9405,
				2264, 5733, 105, 4175, 5448, 5155, 8586, 5610, 6698, 1518, 6581, 4555, 4239, 786, 5709, 2336, 8688,
				9685, 902, 1720, 7216, 3129, 2889, 8756, 71, 6774, 5631, 5528, 6205, 5676, 1683, 6487, 6624, 9819, 3120,
				1874, 2481, 5899, 7993, 5933, 559, 3385, 7918, 6713, 2091, 7355, 8936, 1278, 943, 7227, 2977, 5498,
				3724, 3987, 3418, 4485, 668, 4308, 1331, 8505, 2808, 7837, 1579, 393, 4736, 7360, 7802, 4087, 6978, 110,
				6575, 2339, 8375, 9201, 7809, 9964, 4345, 9863, 5480, 752, 5196, 262, 7603, 5701, 8089, 5014, 6017, 845,
				8953, 7598, 8162, 9200, 7815, 2885, 8905, 4603, 7194, 8237, 5271, 2881, 8765, 6701, 2754, 477, 4656,
				1508, 8534, 7611, 5201, 8767, 6249, 4795, 186, 2050, 1304, 9358, 6769, 5902, 4102, 6119, 7143, 3967,
				6505, 2609, 4263, 1749, 8848, 2604, 3066, 3989, 9342, 1234, 4264, 2733, 3834, 8843, 3232, 3251, 8098,
				3792, 1507, 5179, 3718, 9829, 378, 2570, 6756, 2318, 6019, 5016, 3787, 2260, 8480, 6342, 8593, 1394,
				607, 4963, 9771, 7929, 329, 3550, 4560, 3011, 2723, 4807, 2847, 5833, 2038, 57, 6047, 5948, 5020, 1335,
				5041, 3131, 8939, 3518, 5877, 318, 3748, 5813, 4283, 7033, 9861, 1834, 5572, 5954, 6404, 6500, 4888,
				1297, 5256, 9299, 8731, 3790, 827, 4615, 4366, 3686, 6476, 8589, 3660, 2281, 9529, 4606, 5857, 697,
				1076, 3538, 5233, 6933, 2135, 5222, 4289, 2923, 8737, 4225, 3267, 112, 8476, 2486, 1434, 7478, 4424,
				7511, 996, 9463, 5296, 5880, 4395, 283, 8047, 4374, 2554, 316, 355, 1112, 6826, 7152, 9287, 8794, 3785,
				80, 1121, 7963, 1093, 8553, 9382, 268, 4981, 772, 9378, 6531, 3916, 6452, 7643, 2841, 9800, 7364, 9859,
				3874, 798, 4012, 6838, 3848, 134, 3501, 3494, 8951, 871, 6024, 9279, 494, 6633, 7023, 4780, 4770, 9582,
				1087, 344, 6889, 5682, 301, 6659, 9042, 1156, 8014, 395, 6656, 6082, 8248, 9353, 6704, 106, 9122, 3421,
				6015, 1643, 639, 6238, 8022, 8158, 3114, 7651, 4201, 9091, 5026, 2473, 3965, 8672, 4727, 3990, 3697,
				5170, 7165, 3576, 1571, 5931, 6137, 9329, 7794, 1049, 7617, 3012, 7413, 9751, 8864, 8032, 3032, 9886,
				9429, 75, 8205, 4806, 9559, 2167, 4199, 6211, 8900, 2387, 3638, 575, 9723, 6027, 1207, 6563, 1006, 170,
				1906, 3061, 2074, 4076, 2935, 6042, 3801, 7013, 8631, 2725, 2215, 4693, 9746, 3216, 7708, 7830, 3426,
				8792, 6655, 7778, 139, 4722, 7083, 1325, 642, 3993, 5361, 3586, 988, 711, 3447, 543, 2212, 863, 8427,
				1690, 855, 387, 1472, 1345, 6022, 363, 4838, 7520, 4070, 76, 6412, 2830, 5003, 227, 1539, 1921, 4620,
				2196, 7497, 3617, 770, 1283, 640, 6364, 9532, 3769, 3651, 8360, 8658, 7870, 4826, 3209, 5422, 4382,
				3757, 8582, 630, 7694, 2367, 5956, 5178, 7348, 5582, 2492, 7632, 1009, 1382, 4084, 6262, 9458, 3768,
				3303, 3118, 5551, 5523, 8485, 753, 3889, 9309, 4057, 805, 1460, 3278, 605, 9240, 6146, 5038, 8816, 8277,
				5951, 44, 9763, 3244, 3541, 6473, 7292, 3370, 9815, 2819, 5282, 6625, 6597, 9740, 9332, 5324, 4761,
				1890, 4301, 8153, 7056, 5612, 1732, 6374, 5246, 6113, 8407, 2381, 4340, 1948, 6033, 7471, 6395, 2738,
				637, 5985, 8497, 9148, 6134, 1569, 1744, 3230, 9153, 6840, 2191, 7335, 5554, 2344, 6735, 5348, 3722,
				9027, 1856, 429, 4992, 1397, 8104, 5509, 8834, 7384, 3023, 6941, 3036, 1097, 1085, 2096, 4609, 5959,
				5743, 6096, 7664, 6450, 4100, 3304, 2136, 766, 8053, 7734, 311, 689, 5242, 1052, 8439, 5976, 2466, 9242,
				317, 619, 5408, 5200, 5830, 9473, 2814, 6290, 1594, 7668, 6330, 6927, 3652, 7726, 6728, 8590, 232, 8386,
				5873, 695, 2842, 4545, 4341, 6008, 9801, 7543, 298, 4734, 6807, 1898, 7365, 3897, 1830, 8296, 9, 9704,
				1366, 4293, 6360, 5515, 7663, 9552, 9795, 3094, 3649, 3101, 7107, 4763, 2395, 70, 6791, 4537, 6344,
				8878, 4273, 2837, 3110, 8888, 3242, 6636, 5154, 676, 9853, 108, 3373, 1801, 7777, 8498, 1014, 4788, 624,
				8594, 2452, 4585, 8884, 1066, 9766, 2402, 7774, 2263, 6993, 8653, 7509, 4680, 1626, 8985, 1837, 2749,
				4077, 8567, 7791, 4593, 7727, 1998, 9923, 9366, 1567, 7352, 6135, 9737, 1000, 8255, 5686, 3424, 5665,
				5634, 2429, 9178, 8821, 2955, 8419, 963, 3434, 2004, 366, 5803, 1724, 2233, 2724, 3589, 8647, 4805,
				3255, 9079, 3532, 9081, 7536, 6810, 5049, 660, 2305, 8119, 6833, 8206, 6523, 5275, 3546, 4955, 5710,
				1320, 1046, 820, 5046, 627, 7490, 4899, 8648, 2898, 7931, 6064, 3616, 6107, 3416, 4878, 9097, 4900,
				9055, 8764, 1716, 3871, 7320, 6952, 5337, 8566, 5856, 5172, 9550, 8555, 3817, 4743, 4945, 8698, 9064,
				8928, 6910, 3003, 181, 6647, 7094, 2519, 3123, 1713, 8331, 1903, 3636, 6820, 6564, 726, 651, 3168, 598,
				5048, 5649, 9510, 6989, 4511, 1414, 9499, 6551, 8629, 5466, 7683, 7938, 9156, 4789, 4489, 3923, 7164,
				7077, 5177, 9503, 9300, 4604, 5243, 8964, 7444, 2592, 9060, 4961, 4179, 7283, 8540, 6114, 7620, 7151,
				3777, 9578, 3873, 5919, 2643, 2880, 9373, 593, 2981, 6203, 6932, 5806, 1065, 8417, 8474, 2765, 7667,
				7313, 848, 6461, 1610, 6389, 7522, 7613, 2902, 6226, 670, 5957, 3274, 7533, 5446, 8633, 1953, 3627, 362,
				8866, 8197, 6825, 1593, 1077, 8852, 8724, 6571, 1651, 8740, 3641, 7666, 5656, 5164, 8275, 2603, 4601,
				7697, 5257, 1312, 4490, 3913, 2635, 6886, 2559, 9862, 4930, 348, 4640, 7563, 817, 5513, 2320, 5476,
				1257, 3495, 3034, 274, 6637, 490, 2032, 4046, 3984, 600, 8436, 6368, 3154, 8689, 7481, 5080, 7341, 2406,
				1091, 7069, 1536, 7089, 1685, 1295, 8481, 6710, 6037, 2205, 5740, 2052, 4316, 4450, 5391, 6972, 2291,
				8758, 1547, 2106, 9729, 9167, 2340, 5907, 177, 2298, 4056, 9498, 7386, 5249, 3809, 3500, 6565, 5114,
				340, 2451, 5145, 5964, 3369, 5113, 1231, 2941, 7339, 5230, 6974, 3667, 4373, 448, 3844, 741, 7179, 7906,
				4725, 6504, 7525, 3924, 7672, 4768, 1635, 8394, 675, 5687, 3630, 3716, 8464, 8381, 4625, 2056, 7489,
				2348, 7315, 8531, 1111, 816, 5406, 8762, 5287, 6333, 8371, 1522, 3731, 1669, 2247, 3262, 7685, 4215,
				756, 7293, 4417, 4119, 9345, 2166, 8392, 9113, 2445, 9735, 4334, 8499, 7950, 1411, 8299, 8283, 9973,
				1843, 5001, 1779, 5322, 3357, 6380, 3657, 6792, 3677, 7195, 5698, 284, 6591, 202, 3644, 1865, 7565,
				7215, 2763, 4476, 8537, 8796, 4089, 4030, 680, 503, 6155, 8914, 4035, 6737, 6128, 5313, 5894, 9900, 308,
				5141, 5607, 5071, 925, 2895, 8886, 3951, 1138, 8830, 9159, 4336, 7301, 1194, 8467, 2750, 5637, 5036,
				2380, 830, 1992, 1044, 1332, 8841, 8303, 9591, 3863, 959, 2840, 2349, 99, 2294, 1846, 116, 1477, 7189,
				5306, 7054, 5906, 1474, 2302, 8523, 5502, 2956, 1227, 4746, 1653, 6423, 6061, 2986, 5382, 9171, 6859,
				7291, 9045, 7896, 2547, 3793, 8896, 8674, 5395, 4519, 550, 1239, 8533, 3596, 2289, 479, 7907, 5218,
				9866, 621, 2121, 4871, 1213, 4296, 8516, 8144, 8703, 4943, 5161, 8093, 3508, 3892, 8137, 5736, 7053,
				4505, 7181, 2866, 1364, 5882, 9612, 1311, 3430, 1441, 6890, 257, 4365, 3719, 2221, 8103, 206, 3455,
				9344, 2476, 9327, 5559, 5774, 6514, 2931, 2037, 5387, 1019, 8315, 9197, 8691, 6622, 2405, 1552, 6635,
				5166, 841, 6199, 3398, 2878, 9840, 9478, 3132, 2472, 9767, 5934, 5181, 4887, 7570, 5996, 7544, 1155,
				6921, 1500, 2435, 1333, 5747, 7214, 4598, 4009, 9679, 6731, 1728, 7350, 6261, 8664, 980, 836, 1714,
				6026, 5301, 4668, 5012, 5010, 7615, 9347, 1198, 2174, 1071, 4666, 610, 636, 8624, 2649, 8105, 9736,
				2047, 2362, 8064, 492, 1032, 936, 3832, 5719, 8929, 9433, 6478, 582, 2053, 1249, 8447, 1701, 5910, 1832,
				9339, 2213, 7113, 8802, 5892, 4918, 124, 4538, 4394, 6850, 7686, 821, 7482, 1711, 7596, 5104, 9116,
				4737, 6939, 1864, 3082, 7022, 5197, 5606, 1665, 3519, 2123, 1800, 179, 3728, 8005, 4695, 6619, 5952,
				999, 439, 6773, 946, 8608, 7602, 5491, 2296, 3602, 4829, 1383, 6517, 7057, 887, 8999, 1368, 8343, 8676,
				3833, 7655, 6294, 1404, 3607, 3124, 8966, 1733, 413, 2641, 5738, 613, 5463, 9019, 2729, 950, 2572, 427,
				3248, 6018, 4115, 8717, 3410, 9110, 9293, 3491, 3428, 6053, 5694, 1606, 3343, 2139, 4333, 5750, 4363,
				463, 2537, 8077, 1743, 3972, 518, 6954, 2410, 7942, 7371, 5987, 9253, 2431, 9614, 9561, 6223, 9396,
				2732, 9411, 478, 6524, 9456, 509, 3476, 4696, 1330, 6576, 6574, 2836, 4356, 7812, 9991, 3504, 5002,
				8351, 8051, 4266, 8240, 6324, 2639, 2904, 5624, 8560, 9103, 9649, 9854, 2736, 4790, 5444, 1367, 8654,
				5383, 1421, 3672, 5461, 3828, 3100, 6121, 1315, 9757, 9989, 1095, 2687, 4688, 6138, 7080, 1328, 2359,
				3715, 1362, 1840, 3806, 4227, 6580, 9976, 2477, 7379, 9160, 8192, 4064, 9267, 9643, 6835, 1279, 7930,
				6793, 3827, 1438, 7581, 1911, 5659, 4998, 4597, 263, 9818, 8232, 6895, 4791, 3021, 4068, 8503, 3996,
				4427, 4818, 9162, 483, 4165, 9827, 8739, 9034, 8562, 3655, 1788, 1765, 2014, 8339, 5188, 8457, 5204,
				603, 7123, 2730, 8473, 9020, 969, 7183, 7796, 8711, 4578, 2251, 5941, 8591, 6317, 2532, 7974, 1935,
				4116, 1298, 8925, 8249, 2806, 191, 2612, 4146, 1125, 5176, 4879, 7810, 5195, 4090, 2622, 8382, 9285,
				5525, 6958, 2148, 4065, 4557, 7567, 3683, 8395, 5529, 3162, 2811, 9715, 1767, 1122, 8755, 9631, 8949,
				5496, 5822, 3945, 8411, 6312, 2231, 7753, 5075, 5884, 3932, 3270, 5537, 166, 2315, 436, 6301, 4325,
				6286, 6996, 8079, 8353, 4514, 4475, 4744, 322, 9115, 91, 40, 4121, 5216, 157, 7319, 3685, 6646, 7404,
				4361, 6961, 4274, 5672, 4491, 6981, 924, 4525, 7265, 4125, 9277, 2075, 1204, 5354, 1707, 8402, 5428,
				4234, 9420, 704, 3678, 9652, 1790, 5778, 2879, 3243, 437, 1794, 9754, 37, 713, 3977, 4267, 4523, 6566,
				2468, 750, 6488, 1428, 8692, 1047, 5295, 4271, 7155, 6561, 8458, 2783, 6854, 7391, 520, 3851, 7886,
				6406, 6234, 3985, 5714, 7737, 4747, 3386, 131, 374, 5751, 9259, 4834, 915, 2246, 6618, 3220, 3749, 5841,
				6603, 1036, 9592, 1358, 2552, 2918, 1309, 9555, 5268, 6757, 2088, 2290, 4848, 5445, 3040, 3770, 5095,
				3766, 2961, 6931, 7325, 7585, 6790, 8519, 867, 9824, 1395, 7159, 1557, 5083, 9958, 4708, 4664, 2471,
				8539, 6510, 1236, 4166, 5717, 2979, 4896, 860, 4884, 6956, 634, 722, 2818, 3646, 3691, 3408, 9330, 3564,
				5553, 7914, 9232, 8091, 6409, 8543, 6767, 8825, 7418, 6628, 5988, 622, 7346, 7163, 6343, 6842, 5507,
				5777, 5762, 6816, 163, 3610, 5642, 2751, 3432, 4465, 4648, 9753, 1219, 8850, 6980, 5866, 9837, 6711,
				8901, 2044, 7321, 3487, 1045, 8297, 1750, 352, 9817, 5187, 4384, 847, 9129, 6846, 6366, 9897, 5264,
				6800, 1493, 5205, 5138, 4935, 2677, 9032, 7652, 4138, 2708, 2023, 5308, 6900, 4784, 1343, 6814, 801,
				1787, 2499, 1660, 195, 4187, 9790, 7328, 1929, 7996, 9377, 2156, 4036, 9525, 4231, 6997, 5241, 421,
				7447, 645, 961, 8148, 8733, 3464, 3436, 3908, 5087, 2244, 7755, 3009, 1471, 8272, 5037, 2997, 7698,
				3177, 1799, 2782, 3482, 3898, 2769, 2799, 6067, 7701, 8572, 7212, 9942, 7834, 4472, 1350, 6918, 5040,
				9037, 952, 891, 8715, 440, 3252, 7120, 2055, 755, 886, 8028, 3453, 8931, 6417, 3246, 8009, 6387, 9825,
				3611, 2506, 123, 2272, 8893, 8874, 3938, 7105, 389, 6108, 2066, 1861, 7532, 7299, 8433, 3548, 425, 7087,
				8908, 9024, 5574, 9982, 7174, 8313, 5221, 2447, 9628, 4306, 9551, 7767, 2807, 1164, 552, 4034, 1454,
				8176, 7571, 3786, 545, 1729, 9423, 8824, 1699, 3878, 8938, 671, 3773, 8348, 2321, 5146, 3588, 586, 6311,
				9833, 2721, 5365, 7979, 1662, 8578, 5091, 5588, 1431, 7178, 7241, 3292, 9899, 2011, 7764, 6955, 7372,
				1601, 1791, 747, 2647, 1583, 2536, 2284, 9581, 962, 4831, 1895, 2995, 4182, 568, 5202, 9017, 6063, 5380,
				6038, 337, 7454, 9945, 3405, 1853, 6424, 3400, 3517, 527, 496, 2255, 3870, 7580, 6229, 5303, 5673, 2788,
				8530, 6277, 1620, 4488, 8971, 7854, 5662, 9598, 4079, 5848, 1104, 7036, 5730, 2027, 4573, 8401, 4195,
				1566, 4037, 1578, 23, 9459, 5692, 3141, 1900, 9977, 6585, 2316, 2556, 3865, 775, 702, 3261, 7702, 6186,
				9697, 6475, 5657, 4970, 225, 9000, 2308, 803, 3469, 5309, 5780, 1603, 7012, 7954, 5723, 6676, 5915, 990,
				8383, 2797, 114, 901, 2565, 3902, 8494, 8178, 1416, 400, 6556, 6272, 2590, 1462, 482, 978, 2947, 7593,
				1939, 5486, 972, 8766, 8747, 824, 5721, 971, 9701, 2495, 7467, 3122, 7807, 5131, 787, 2916, 1108, 6356,
				303, 6265, 324, 3381, 4459, 1090, 450, 4224, 7665, 7277, 1265, 4205, 2078, 6353, 6926, 1838, 3142, 5440,
				3711, 5352, 2201, 4719, 692, 1704, 349, 9057, 449, 3997, 2523, 6309, 7908, 8588, 488, 7246, 5121, 7832,
				8325, 1148, 2823, 3556, 2790, 8956, 6481, 7811, 3585, 4571, 3458, 8927, 5000, 8761, 8617, 1555, 571,
				6727, 9331, 6678, 193, 2541, 9990, 2076, 5965, 1109, 497, 1430, 271, 6386, 7007, 4400, 7375, 9865, 6239,
				2332, 1174, 326, 1073, 3727, 119, 8242, 9472, 3928, 3488, 487, 5801, 9939, 2286, 486, 3906, 9506, 1990,
				4951, 9435, 3319, 3881, 4383, 9190, 2900, 4699, 1078, 8469, 6383, 8671, 2535, 1080, 5173, 1403, 4339,
				840, 2375, 5928, 638, 154, 5601, 974, 3829, 8955, 9449, 1585, 3998, 5726, 7062, 4050, 2851, 573, 4822,
				7434, 9316, 3394, 7017, 6776, 707, 236, 3846, 3921, 6318, 1208, 9796, 5429, 2843, 1833, 7970, 5115,
				4629, 9979, 3073, 9179, 9896, 8037, 5829, 3706, 3955, 6384, 7928, 6088, 7850, 1866, 4323, 1592, 8252,
				4281, 8548, 3115, 4618, 1171, 8239, 1183, 6070, 2324, 506, 6740, 7992, 8378, 6783, 6449, 6589, 9390,
				2279, 3939, 719, 4211, 8549, 8526, 7789, 6782, 98, 8859, 8620, 7513, 6151, 3852, 9905, 9914, 4553, 789,
				4813, 3146, 3272, 7144, 9739, 1886, 3380, 9338, 7408, 6280, 4677, 3346, 5592, 2990, 8835, 534, 589,
				4698, 11, 6544, 1681, 9778, 797, 5194, 1752, 9406, 8775, 3181, 7370, 5793, 3597, 1875, 4717, 7158, 7385,
				1519, 3480, 1220, 7332, 7763, 7119, 6734, 2825, 516, 6880, 5752, 4815, 5731, 2082, 970, 6503, 6440,
				6863, 9092, 9975, 5142, 1754, 6244, 5789, 3263, 2755, 7026, 3525, 2379, 1916, 5838, 6454, 9485, 3112,
				8584, 9138, 361, 8002, 7131, 1870, 302, 1386, 30, 16, 1293, 1272, 7779, 5450, 2913, 2999, 4942, 9284,
				9315, 8627, 5212, 4772, 9580, 685, 3982, 1945, 2158, 941, 1596, 465, 7229, 5504, 6558, 277, 7198, 7125,
				6372, 1392, 1346, 2220, 8416, 8311, 814, 4940, 2112, 5908, 2002, 9204, 7994, 3797, 2883, 5540, 5739,
				4958, 6905, 8387, 1673, 2893, 9665, 2386, 8700, 9376, 1512, 8525, 5993, 7230, 913, 7079, 323, 3368,
				2498, 579, 4369, 2839, 5030, 2484, 6828, 706, 4311, 2436, 6848, 4580, 7269, 3637, 6920, 7887, 1189,
				3729, 1191, 9168, 2821, 8426, 6337, 7838, 1542, 2080, 94, 9071, 3837, 2728, 3810, 4162, 8719, 6602,
				8891, 4920, 8869, 31, 7740, 405, 9604, 652, 9700, 2119, 8670, 8744, 6717, 6778, 3050, 3260, 5302, 6578,
				5108, 6035, 9903, 7015, 3803, 2067, 4085, 5561, 7915, 7519, 5947, 7712, 1450, 8316, 8049, 2415, 4988,
				3133, 8400, 4430, 529, 9546, 3614, 587, 6862, 2844, 6052, 2115, 8393, 3831, 4479, 1782, 5615, 3316,
				2717, 1863, 1266, 1130, 505, 4474, 4043, 3690, 4062, 4130, 8656, 5798, 1016, 2245, 101, 1063, 1259,
				3264, 4223, 932, 9922, 4018, 6101, 2351, 2008, 4634, 8870, 2975, 544, 2888, 9125, 8060, 7074, 8140,
				9249, 1930, 6218, 5378, 9023, 530, 5043, 38, 7078, 5983, 8551, 7653, 6684, 1572, 9369, 7965, 1303, 4416,
				6829, 9557, 4371, 9878, 2858, 8161, 417, 7425, 3530, 7403, 6477, 9051, 3273, 9365, 7765, 6611, 7752,
				8640, 3332, 6190, 1480, 1560, 4221, 1599, 8084, 6663, 6811, 7757, 4661, 5865, 2911, 6117, 5708, 1591,
				2938, 9182, 1447, 6039, 4742, 3236, 1598, 6903, 3375, 5150, 2144, 7445, 8602, 8695, 1195, 8806, 1695,
				208, 832, 4541, 983, 4425, 555, 3964, 7446, 7546, 2852, 7021, 9809, 6687, 5314, 8697, 1611, 6681, 9210,
				2459, 5054, 6592, 7710, 796, 1352, 8410, 3936, 9362, 4449, 401, 8962, 9690, 8790, 8799, 9260, 1556,
				4726, 1991, 782, 1070, 6559, 1252, 5675, 103, 9328, 3864, 5989, 4683, 6297, 6213, 4153, 1947, 3191,
				5021, 1531, 7607, 6185, 6393, 4396, 7534, 1607, 710, 1273, 1965, 5746, 4529, 3799, 3696, 9216, 8751,
				683, 3959, 9453, 9630, 8448, 7717, 6843, 3225, 1182, 9391, 6696, 7439, 3104, 5250, 8045, 8801, 7048,
				8127, 8441, 5636, 82, 1437, 7376, 5670, 7130, 9879, 4123, 3935, 7659, 2450, 794, 1632, 2580, 2454, 3169,
				8368, 2933, 4907, 8912, 650, 5869, 3698, 5327, 2275, 6877, 7047, 2102, 9484, 9291, 7075, 2906, 2482,
				3440, 1762, 6801, 9902, 5573, 5364, 6458, 6680, 9004, 911, 8454, 563, 4549, 4799, 7940, 6780, 9969,
				9599, 3957, 2533, 3291, 658, 243, 3001, 1034, 7393, 6331, 8243, 5843, 2591, 7776, 3577, 5820, 6497,
				6951, 6, 2753, 5872, 7032, 4914, 5060, 3818, 7317, 1679, 1161, 9173, 7400, 6721, 1041, 3266, 345, 7821,
				1949, 4630, 3771, 6485, 8871, 423, 5973, 4039, 8423, 2428, 3622, 7476, 2442, 2574, 9217, 2964, 4901,
				270, 3390, 9993, 205, 3583, 9161, 2772, 5802, 6171, 8544, 5842, 7893, 1299, 4926, 6086, 724, 5353, 9231,
				8445, 6839, 5123, 226, 6650, 49, 6702, 2681, 2460, 2507, 2678, 5133, 2226, 2180, 6648, 3943, 2494, 9793,
				1621, 3714, 4410, 1106, 9175, 8507, 9005, 6240, 255, 3020, 6065, 8511, 9674, 2258, 6797, 4939, 3105,
				3819, 8655, 1211, 3573, 839, 7528, 3565, 2524, 6182, 7820, 8332, 9566, 8583, 3415, 7579, 5370, 3549,
				6192, 965, 849, 4091, 187, 8854, 9564, 9479, 2464, 5011, 736, 2019, 9811, 4632, 8673, 5356, 3468, 328,
				8947, 6072, 5073, 5325, 9146, 3581, 718, 9626, 424, 354, 2966, 8810, 3287, 4181, 2283, 8086, 6552, 1826,
				1114, 9597, 4611, 1314, 3404, 9725, 6573, 3901, 8889, 74, 1943, 851, 6009, 138, 8370, 4484, 1197, 2555,
				6076, 8449, 4335, 4161, 493, 7945, 7210, 307, 8128, 9744, 1543, 454, 1192, 4608, 8493, 5558, 3895, 9257,
				2907, 9640, 5066, 2598, 351, 4925, 7531, 8071, 9913, 468, 3382, 514, 3450, 2722, 3544, 8384, 4657, 8520,
				8245, 1537 }; // Input

		int[] sortedList = new int[sortList.length]; // Output

		int maxItem = sortList[0];
		int minItem = sortList[0];

		// Finding maximum and minimum item in the sortList array
		for (int i = 1; i < sortList.length; i++) {
			if (sortList[i] > maxItem) {
				maxItem = sortList[i];
			}
			
			if (sortList[i] < minItem) {
				minItem = sortList[i];
			}
		}

		int[] spaceSorted = new int[maxItem - minItem + 1]; // This is the sorted array, but it has spaces

		// Setting input list to the spaced out list
		for (int i = 0; i < sortList.length; i++) {
			spaceSorted[sortList[i] - minItem] = sortList[i];
		}

		// Moving non-null (0) items to the final array
		int j = 0;
		for (int i = 0; i < sortedList.length; i++) {

			// Skipping to next item if it is 0
			while (spaceSorted[j] == 0) {
				j++;
			}

			// Adding non-zero item to the final sorted list
			sortedList[i] = spaceSorted[j];
			j++;
		}

		// Printing out final sorted list
		for (int i = 0; i < sortedList.length; i++) {
			System.out.println(sortedList[i]);
		}

		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		System.out.println("Millis: " + time);
	}
}
