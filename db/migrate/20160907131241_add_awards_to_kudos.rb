class AddAwardsToKudos < ActiveRecord::Migration[5.0]
  def change
  	add_reference :kudos, :awards, index: true
  end
end
